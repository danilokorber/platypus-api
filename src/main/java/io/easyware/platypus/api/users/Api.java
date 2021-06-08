package io.easyware.platypus.api.users;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.inject.Inject;
import javax.mail.search.SearchTerm;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("users")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    @Inject
    SecurityIdentity identity;

    @GET
    @Path("me")
    @NoCache
    public SecurityIdentity me() {
        return identity;
    }

    @GET
    @Path("me/roles")
    @NoCache
    public Set<String> meRoles() {
        return identity.getRoles();
    }
}
