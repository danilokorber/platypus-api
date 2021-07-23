package io.easyware.platypus.api.fin;

import io.easyware.platypus.api.fin.objects.CostCenter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("fin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {
    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    @Inject
    Service service;

    @GET
    @Path("cost_centers")
    public Response getCostCentersForDomain(@QueryParam("domain_id") int domainId) {
        if (domainId > 0) {
            LOGGER.log(Level.INFO, "Looking cost centers of domain " + domainId);
            return Response.ok().entity(service.getCostCenters(domainId)).build();
        } else {
            LOGGER.log(Level.SEVERE, "domain_id is a mandatory query parameter.");
            return Response.serverError().entity("domain_id is a mandatory query parameter.").build();
        }
    }

    @POST
    @Path("cost_centers")
    public Response postCostCentersForDomain(CostCenter costCenter) {
        LOGGER.log(Level.INFO, "Creating new cost center " + costCenter.getName());
        CostCenter newlyAddedCostCenter = service.addCostCenter(costCenter);
        final URI newCostCenterUri = UriBuilder.fromResource(Api.class).path("cost_centers/{id}").build(newlyAddedCostCenter.getId());
        return Response.created(newCostCenterUri).entity(newlyAddedCostCenter).build();
    }
}
