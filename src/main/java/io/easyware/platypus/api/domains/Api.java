package io.easyware.platypus.api.domains;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("domains")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    @Inject
    Service service;

    @Inject
    SecurityIdentity identity;

    @GET
    public Response getProjectsOfAccount() {
        return Response.ok().entity(service.getDomainsFromAccount(identity)).build();
    }
}
