package io.easyware.platypus.api.mail;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
@RegisterRestClient(configKey = "imap")
public interface Service {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{account}/messages")
    MessageList get(@PathParam("account") String account, @QueryParam("path") String path);

}
