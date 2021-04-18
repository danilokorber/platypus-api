package io.easyware.platypus.api.mail;

import io.easyware.platypus.api.mail.objects.*;
import io.easyware.platypus.api.mail.objects.Thread;
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

    Helper helper = new Helper();

    public ArrayList<Message> getMessages(String account, @DefaultValue("Inbox") String path,  @DefaultValue("false") boolean unreadOnly) {
        ArrayList<Message> messages = service.get(account, path).getMessages();
        return unreadOnly ? toArrayList(messages.stream().filter(message -> message.isUnseen())) : messages;
    }
    public ArrayList<Message> getMessagesFromThread(String account, String threadId, @DefaultValue("[Gmail]/Todos os e-mails") String path,  @DefaultValue("false") boolean unreadOnly) {
        SearchBody.Filters filter = new SearchBody.Filters();
        filter.threadId = threadId;
        SearchBody body = new SearchBody();
        body.search = filter;
        ArrayList<Message> messages = service.search(account, path, body).getMessages();
        return messages;
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

    // GET /{account}/threads
    @GET
    @Path("/{account}/threads")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountThreads(@PathParam("account") String account, @DefaultValue("Inbox") @QueryParam("path") String path) {
        ArrayList<Message> messages = getMessages(account, path, false);
        ArrayList<Thread> threads = helper.threadsOnly(messages);
        return Response.ok().entity(threads).build();
    }

    // GET /{account}/threads/{threadId}
    @GET
    @Path("/{account}/threads/{threadId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountThreadDetails(@PathParam("account") String account, @PathParam("threadId") String threadId) {
        ArrayList<Message> messages = getMessagesFromThread(account, threadId, "[Gmail]/Todos os e-mails", false);
        return Response.ok().entity(messages).build();
    }

    // GET /{account}/messages
    @GET
    @Path("/{account}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountMessages(@PathParam("account") String account, @DefaultValue("Inbox") @QueryParam("path") String path) {
        ArrayList<Message> messages = getMessages(account, path, false);
        return Response.ok().entity(messages).build();
    }

    // GET /{account}/messages/text/{textId}
    @GET
    @Path("/{account}/messages/text/{textId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAccountMessageText(@PathParam("account") String account, @PathParam("textId") String textId) {
        Text text = service.getText(account, textId);
        return Response.ok().entity(text.getPlain()).build();
    }

    // GET /{account}/messages/text/{textId}
    @GET
    @Path("/{account}/messages/html/{textId}")
    @Produces(MediaType.TEXT_HTML)
    public Response getAccountMessageHtml(@PathParam("account") String account, @PathParam("textId") String textId) {
        Text text = service.getText(account, textId);
        return Response.ok().entity(text.getHtml()).build();
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
