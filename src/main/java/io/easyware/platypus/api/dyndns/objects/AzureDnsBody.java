package io.easyware.platypus.api.dyndns.objects;

import java.util.ArrayList;

public class AzureDnsBody {
    public AzureDnsBody() {}

    public Properties properties;

    public static class Properties {
        public Properties() {}
        public Metadata metadata;
        public int TTL;
        public ArrayList<ARecord> ARecords;

        public static class Metadata {
            public Metadata() {}
            public String key1;
        }

        public static class ARecord {
            public ARecord() {}
            public String ipv4Address;
        }
    }
}
