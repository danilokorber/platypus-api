package io.easyware.platypus.api.projects;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("projects")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    @Inject
    Service service;

    @Inject
    SecurityIdentity identity;

    @GET
    public Response getProjectsOfAccount() {
        return Response.ok().entity(service.getProjectsOfAccount(identity)).build();
    }
}
