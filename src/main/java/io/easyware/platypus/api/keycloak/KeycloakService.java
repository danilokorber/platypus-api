package io.easyware.platypus.api.keycloak;

import io.easyware.platypus.api.keycloak.objects.Role;
import io.easyware.platypus.api.keycloak.objects.TokenResponseBody;
import io.easyware.platypus.api.users.objects.Profile;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@RegisterRestClient(configKey = "keycloak")
public interface KeycloakService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin/realms/{realm}/roles")
    ArrayList<Role> getAllRoles(@PathParam("realm") String realm, @HeaderParam("Authorization") String bearerToken);

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("realms/master/protocol/openid-connect/token")
    TokenResponseBody newToken(@MultipartForm Form body);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin/realms/{realm}/roles")
    void createRole(@PathParam("realm") String realm,
                    @MultipartForm Role role,
                    @HeaderParam("Authorization") String bearerToken);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin/realms/{realm}/users/{userId}/role-mappings/realm")
    void addRoleToUser(@PathParam("realm") String realm,
                       @PathParam("userId") String userId,
                       @MultipartForm ArrayList<Role> role,
                       @HeaderParam("Authorization") String bearerToken);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin/realms/{realm}/users/{userId}")
    void updateUser(@PathParam("realm") String realm,
                    @PathParam("userId") String userId,
                    @MultipartForm Profile profile,
                    @HeaderParam("Authorization") String bearerToken);

}
