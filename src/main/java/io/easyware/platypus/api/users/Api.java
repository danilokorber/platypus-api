package io.easyware.platypus.api.users;

import io.easyware.platypus.api.keycloak.KeycloakService;
import io.easyware.platypus.api.keycloak.objects.TokenRequestBody;
import io.easyware.platypus.api.keycloak.objects.TokenResponseBody;
import io.easyware.platypus.api.users.objects.UserRepresentation;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.logging.Logger;

@Path("users")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {
    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    @Inject
    SecurityIdentity identity;

    @Inject
    JsonWebToken jwt;

    @Inject
    @RestClient
    KeycloakService keycloakService;

    private String bearerToken() {
        TokenRequestBody request = new TokenRequestBody();
        TokenResponseBody response = keycloakService.newToken(request.getBody());
        return "Bearer " + response.getAccess_token();
    }

    @GET
    @Path("me")
    @NoCache
    public Response me() {
        UserRepresentation userRepresentation = keycloakService.getUser("platypus", jwt.getSubject(), bearerToken());
        return Response.ok().entity(userRepresentation).build();
    //public SecurityIdentity me() {
        //return identity;
    }

    @PUT
    @Path("me")
    @NoCache
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mePut(UserRepresentation userRepresentation) {
        keycloakService.updateUser("platypus", jwt.getSubject(), userRepresentation, bearerToken());
        return Response.ok().entity(userRepresentation).build();
    }

    @GET
    @Path("me/roles")
    @NoCache
    public Set<String> meRoles() {
        return identity.getRoles();
    }
}
