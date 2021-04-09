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

import static io.easyware.platypus.shared.Common.toArrayList;

@Path("/mail")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    @Inject
    @RestClient
    Service service;

    public ArrayList<Message> getMessages(String account, @DefaultValue("Inbox") String path,  @DefaultValue("false") boolean unreadOnly) {
        ArrayList<Message> messages = service.get(account, path).getMessages();
        return unreadOnly ? toArrayList(messages.stream().filter(message -> message.isUnseen())) : messages;
    }

    // GET /webhook
    @POST
    @Path("/webhook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response webhook(WebhookMessage webhookMessage) {
        if (webhookMessage.getSpecialUse().contains("\\All")) {
            MessageList messages = service.get(webhookMessage.getAccount(), webhookMessage.getPath());
            long unreadMessages = messages.getMessages().stream().filter(message -> message.isUnseen()).count();
        }
        return Response.ok().build();
    }

    // GET /{account}/messages
    @GET
    @Path("/{account}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountMessages(@PathParam("account") String account, @DefaultValue("Inbox") @QueryParam("path") String path) {
        ArrayList<Message> messages = getMessages(account, path, false);
        return Response.ok().entity(messages).build();
    }

    // GET /{account}/messages/count
    @GET
    @Path("/{account}/messages/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountMessagesCount(@PathParam("account") String account, @DefaultValue("Inbox") @QueryParam("path") String path) {
        ArrayList<Message> unreadMessages = getMessages(account, path, false);
        return Response.ok().entity(unreadMessages.size()).build();
    }

    // GET /{account}/messages/unread
    @GET
    @Path("/{account}/messages/unread")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountMessagesUnread(@PathParam("account") String account, @DefaultValue("Inbox") @QueryParam("path") String path) {
        ArrayList<Message> unreadMessages = getMessages(account, path, true);
        return Response.ok().entity(unreadMessages).build();
    }

    // GET /{account}/messages/unread/count
    @GET
    @Path("/{account}/messages/unread/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountMessagesUnreadCount(@PathParam("account") String account, @DefaultValue("Inbox") @QueryParam("path") String path) {
        ArrayList<Message> unreadMessages = getMessages(account, path, true);
        return Response.ok().entity(unreadMessages.size()).build();
    }


}
