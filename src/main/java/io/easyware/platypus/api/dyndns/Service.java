package io.easyware.platypus.api.dyndns;

import io.easyware.platypus.api.dyndns.objects.AzureDnsBody;
import io.easyware.platypus.api.mail.objects.SearchBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("subscriptions")
@RegisterRestClient(configKey = "azure")
public interface Service {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Network/dnsZones/{zoneName}/{recordType}/{relativeRecordSetName}")
    String updateDynDNS(
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("zoneName") String zoneName,
            @PathParam("recordType") String recordType,
            @PathParam("relativeRecordSetName") String relativeRecordSetName, @MultipartForm AzureDnsBody body);
}
