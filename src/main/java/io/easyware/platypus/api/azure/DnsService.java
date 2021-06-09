package io.easyware.platypus.api.azure;

import io.easyware.platypus.api.azure.objects.dns.RequestBody;
import io.easyware.platypus.api.azure.objects.dns.ResponseBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("subscriptions")
@RegisterRestClient(configKey = "azure-mgmt")
public interface DnsService {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Network/dnsZones/{zoneName}/{recordType}/{relativeRecordSetName}")
    String updateDNS(
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("zoneName") String zoneName,
            @PathParam("recordType") String recordType,
            @PathParam("relativeRecordSetName") String relativeRecordSetName,
            @HeaderParam("Authorization") String authorization,
            @MultipartForm RequestBody body,
            @QueryParam("api-version") String apiVersion);
}
