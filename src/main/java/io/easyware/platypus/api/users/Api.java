package io.easyware.platypus.api.users;

import io.easyware.platypus.api.users.objects.Profile;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("users")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {
    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    @Inject
    SecurityIdentity identity;

    @GET
    @Path("me")
    @NoCache
    public SecurityIdentity me() {
        return identity;
    }

    @PUT
    @Path("me")
    @NoCache
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mePut(Profile profile) {
        LOGGER.log(Level.INFO, "API Call");
        return Response.ok().entity(identity.getAttribute("sub").toString()).build();
    }

    @GET
    @Path("me/roles")
    @NoCache
    public Set<String> meRoles() {
        return identity.getRoles();
    }
}
