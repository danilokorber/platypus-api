package io.easyware.platypus.api.mail;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mail")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    @Inject
    @RestClient
    Service service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        MessageList messages = service.get("Danilo", "Inbox");
        System.out.println(messages.toString());
        return Response.ok().entity(messages).build();
        //return Response.ok().entity("OK").build();
    }

    @POST
    @Path("/webhook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response webhook(WebhookMessage webhookMessage) {
        System.out.println(webhookMessage.getData().toString());
        return Response.ok().build();
    }
}
