package io.easyware.platypus.api.mail;

import io.easyware.platypus.api.mail.objects.MessageList;
import io.easyware.platypus.api.mail.objects.SearchBody;
import io.easyware.platypus.api.mail.objects.Text;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
@RegisterRestClient(configKey = "imap")
public interface Service {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{account}/messages")
    MessageList get(@PathParam("account") String account, @QueryParam("path") String path);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{account}/text/{textId}")
    Text getText(@PathParam("account") String account, @PathParam("textId") String textId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{account}/search")
    MessageList search(@PathParam("account") String account, @QueryParam("path") String path, @MultipartForm SearchBody body);

}
