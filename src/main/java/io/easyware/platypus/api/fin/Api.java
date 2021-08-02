package io.easyware.platypus.api.fin;

import io.easyware.platypus.api.fin.objects.CostCenter;
import io.easyware.platypus.api.keycloak.Permissions;
import io.easyware.platypus.exceptions.PlatypusPermissionsException;

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
        LOGGER.log(Level.INFO, "Looking cost centers of domain " + domainId);

        try {
            return Response.ok().entity(service.getCostCenters(domainId)).build();
        } catch (PlatypusPermissionsException e) {
            return Response.status(401).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("cost_centers")
    public Response postCostCentersForDomain(CostCenter costCenter) {
        LOGGER.log(Level.INFO, "Creating new cost center " + costCenter.getName());

        try {
            costCenter.setActive(true);
            CostCenter newlyAddedCostCenter = service.addCostCenter(costCenter);
            final URI newCostCenterUri = UriBuilder.fromResource(Api.class).path("cost_centers/{id}").build(newlyAddedCostCenter.getId());
            return Response.created(newCostCenterUri).entity(newlyAddedCostCenter).build();
        } catch (PlatypusPermissionsException e) {
            return Response.status(401).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("cost_centers/{id}")
    public Response deleteCostCentersForDomain(@PathParam("id") int id) throws PlatypusPermissionsException {
        LOGGER.log(Level.INFO, "Deleting cost center " + id);

        try{
            service.deleteCostCenter(id);
            return Response.accepted().build();
        } catch (PlatypusPermissionsException e) {
            return Response.status(401).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("expenses")
    public Response getExpenses(@QueryParam("domain_id") int domainId) {
        LOGGER.log(Level.INFO, "Looking expenses of domain " + domainId);

        try {
            return Response.ok().entity(service.getExpenses(domainId)).build();
        } catch (PlatypusPermissionsException e) {
            return Response.status(401).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
