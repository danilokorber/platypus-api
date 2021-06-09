package io.easyware.platypus.api.azure.objects.dns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBody {
    public RequestBody(String host, String ip) {
        this.properties = new Properties();

        ARecord aRecord = new ARecord();
        aRecord.setIpv4Address(ip);
        ArrayList<ARecord> ipList = new ArrayList<ARecord>();
        ipList.add(aRecord);
        this.properties.setARecords(ipList);
    }

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


}
