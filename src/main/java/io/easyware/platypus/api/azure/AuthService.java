package io.easyware.platypus.api.azure;

import io.easyware.platypus.api.azure.objects.auth.TokenRequestBody;
import io.easyware.platypus.api.azure.objects.auth.TokenResponseBody;
import io.easyware.platypus.api.azure.objects.dns.RequestBody;
import io.easyware.platypus.api.azure.objects.dns.ResponseBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "azure-auth")
public interface AuthService {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{tenantId}/oauth2/token")
    TokenResponseBody newToken(
            @PathParam("tenantId") String tenantId,
            @MultipartForm Form body);
}
