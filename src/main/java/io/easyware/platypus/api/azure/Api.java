package io.easyware.platypus.api.azure;

import io.easyware.platypus.api.azure.objects.auth.TokenRequestBody;
import io.easyware.platypus.api.azure.objects.auth.TokenResponseBody;
import io.easyware.platypus.api.azure.objects.dns.RequestBody;
import io.easyware.platypus.api.azure.objects.dns.ResponseBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("dyndns")
public class Api {

    private static final Logger LOGGER = Logger.getLogger( io.easyware.platypus.api.azure.Api.class.getName() );

    @Inject
    @RestClient
    DnsService dnsService;

    @Inject
    @RestClient
    AuthService authService;

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("ipaddr") String ipaddr, @QueryParam("domain") String domain) {
        RequestBody body = new RequestBody(domain, ipaddr);

        LOGGER.log(Level.INFO, "Generating token");
        TokenResponseBody tokenBody = authService.newToken("24c36f42-0890-4308-ba58-fc1b16511794", new TokenRequestBody().getBody());
        LOGGER.log(Level.INFO, "Token generated");
        String authorization = "Bearer " + tokenBody.getAccess_token();

        try {
            String responseBody = dnsService.updateDNS(
                    "cf96b2fd-20c4-4709-b4c7-e87ca6703279",
                    "korber",
                    "korber.com.br",
                    "A",
                    domain,
                    authorization,
                    body,
                    "2018-05-01");
            return Response.ok().entity(responseBody).build();
        }
        catch (Exception err) {
            LOGGER.log(Level.SEVERE, err.getMessage());
            return Response.serverError().entity(err).build();
        }

    }
}
