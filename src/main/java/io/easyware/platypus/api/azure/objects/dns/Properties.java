package io.easyware.platypus.api.azure.objects.dns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

    public Properties() {}

    private Metadata metadata;
    private String fqdn;
    private int TTL = 3600;
    private ArrayList<ARecord> ARecords;
    private String provisioningState;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

    public int getTTL() {
        return TTL;
    }

    public void setTTL(int TTL) {
        this.TTL = TTL;
    }

    public ArrayList<ARecord> getARecords() {
        return ARecords;
    }

    public void setARecords(ArrayList<ARecord> ARecords) {
        this.ARecords = ARecords;
    }

    public String getProvisioningState() {
        return provisioningState;
    }

    public void setProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
    }
}
