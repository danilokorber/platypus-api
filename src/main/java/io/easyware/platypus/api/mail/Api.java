package io.easyware.platypus.api.mail;

import io.easyware.platypus.api.mail.objects.Message;
import io.easyware.platypus.api.mail.objects.MessageList;
import io.easyware.platypus.api.mail.objects.WebhookMessage;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

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

        System.out.println("New message from in " + webhookMessage.getSpecialUse() + " for " + webhookMessage.getData().getFrom().getAddress());
        if (webhookMessage.getSpecialUse() == "\\\\All") {
            System.out.print("Checking still unread messages.... ");
            MessageList messages = service.get(webhookMessage.getAccount(), webhookMessage.getPath());
            long unreadMessages = messages.getMessages().stream().filter(message -> message.isUnseen()).count();
            System.out.println(unreadMessages + " unread messages found.");
        }

        return Response.ok().build();
    }
}
