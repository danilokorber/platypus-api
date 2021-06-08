package io.easyware.platypus.api.dyndns;

import io.easyware.platypus.api.dyndns.objects.AzureDnsBody;
import io.easyware.platypus.api.mail.Service;
import io.easyware.platypus.api.mail.objects.MessageList;
import io.easyware.platypus.api.mail.objects.WebhookMessage;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("dyndns")
public class Api {

    private static final Logger LOGGER = Logger.getLogger( io.easyware.platypus.api.dyndns.Api.class.getName() );

    @Inject
    @RestClient
    Service service;

    @GET
    @Path("update")
    public Response update(@QueryParam("ipaddr") String ipaddr, @QueryParam("domain") String domain) {
        LOGGER.log(Level.INFO, ipaddr);
        LOGGER.log(Level.INFO, domain);

        //AzureDnsBody body = new AzureDnsBody();
        //body.properties.metadata.key1 = domain;
        //body.properties.TTL = 3600;
        //AzureDnsBody.Properties.ARecord aRecord = new AzureDnsBody.Properties.ARecord();
        //aRecord.ipv4Address = ipaddr;


        return Response.ok().build();
    }
}
