package io.easyware.platypus.api.domains;

import io.easyware.platypus.api.keycloak.KeycloakService;
import io.easyware.platypus.api.keycloak.objects.Role;
import io.easyware.platypus.api.keycloak.objects.TokenRequestBody;
import io.easyware.platypus.api.keycloak.objects.TokenResponseBody;
import io.easyware.platypus.api.domains.objects.Domain;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.jwt.auth.principal.DefaultJWTCallerPrincipal;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("domains")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    @Inject
    Service service;

    @Inject
    @RestClient
    KeycloakService keycloakService;

    @Inject
    SecurityIdentity identity;

    @Inject
    JsonWebToken jwt;

    private String bearerToken() {
        TokenRequestBody request = new TokenRequestBody();
        TokenResponseBody response = keycloakService.newToken(request.getBody());
        return "Bearer " + response.getAccess_token();
    }

    @GET
    public Response getProjectsOfAccount() {
        return Response.ok().entity(service.getAllFromAccount(identity)).build();
    }

    @POST
    public Response createDomain(Domain domain) {
        String uuid = UUID.randomUUID().toString();
        Domain newCreatedDomain = new Domain();

        // Inserting domain in database
        domain.setUid(uuid);
        domain.setActive(true);
        domain.setCreatedAt(new Date());
        domain.setCreatedBy(identity.getPrincipal().getName());
        LOGGER.log(Level.INFO, "Inserting domain " + domain.getName() + " in database.");
        try {
            newCreatedDomain = service.add(domain);
            LOGGER.log(Level.INFO, "Domain " + newCreatedDomain.getName() + " created successfully in database.");
        } catch(Exception err) {
            LOGGER.log(Level.SEVERE, err.getMessage());
            return Response.serverError().entity(err).build();
        }

        // Creating role in keycloak
        Role role = new Role(uuid, domain.getName());
        LOGGER.log(Level.INFO, "Creating role " + uuid + " in keycloak");
        try {
            keycloakService.createRole("Platypus", role, bearerToken());
            LOGGER.log(Level.INFO, "Role " + domain.getName() + " created successfully in keycloak.");
        } catch(Exception err) {
            LOGGER.log(Level.SEVERE, err.getMessage());
            return Response.serverError().entity(err).build();
        }

        // Get new role ID
        try {
            ArrayList<Role> allRoles = keycloakService.getAllRoles("Platypus", bearerToken());
            ArrayList<Role> newCreatedRoles = allRoles.stream().filter(r -> r.getName().equals(uuid) ).collect(Collectors.toCollection(ArrayList::new));
            LOGGER.log(Level.INFO, newCreatedRoles.size() + " roles found.");

            if (newCreatedRoles.isEmpty()) {
                LOGGER.log(Level.WARNING, "Role " + uuid + " not found! Existing roles are:");
                allRoles.stream().forEach(r -> LOGGER.log(Level.WARNING, r.getName()));
                return Response.serverError().entity("No new roles were found").build();

            }
            LOGGER.log(Level.INFO, "New role id is " + newCreatedRoles.get(0).getId() + ".");

            // Add user to role in keycloak
            String userId = jwt.getClaim("sub");
            keycloakService.addRoleToUser("Platypus", userId, newCreatedRoles, bearerToken());
            LOGGER.log(Level.INFO, "User " + identity.getPrincipal().getName() + " assigned to role " + newCreatedRoles.get(0).getName() + ".");
        } catch(Exception err) {
            LOGGER.log(Level.SEVERE, err.getMessage());
            return Response.serverError().entity(err).build();
        }

        return Response.status(201).entity(newCreatedDomain).build();
    }
}
