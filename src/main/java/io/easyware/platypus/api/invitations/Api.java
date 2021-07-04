package io.easyware.platypus.api.invitations;

import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("rsvp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {
    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    @Inject
    Service service;

    @GET
    @Path("invitation/{invitationId}")
    public Response getInvitation(@PathParam("invitationId") String invitationId) {
            service.scan(invitationId);
            return Response.ok().entity(service.getInvitation(invitationId)).build();
    }

    @POST
    @Path("invitation/{invitationId}")
    public Response postConfirmation(@PathParam("invitationId") String invitationId, @DefaultValue("false") @QueryParam("confirm") Boolean confirm) {
        return Response.accepted().entity(service.postConfirmation(invitationId, confirm)).build();
    }

    @GET
    @Path("event/{eventId}")
    public Response getInvitationsFromEvent(@PathParam("eventId") String eventId) {
        return Response.ok().entity(service.getInvitationsFrom(eventId)).build();
    }
}
