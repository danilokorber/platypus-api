package io.easyware.platypus.api.mail.objects;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class SearchBody {
    public SearchBody() {}

    @FormParam("search")
    @PartType(MediaType.TEXT_PLAIN)
    public Filters search;

    public static class Filters {
        public Filters() {}

        @FormParam("threadId")
        @PartType(MediaType.TEXT_PLAIN)
        public String threadId;
    }
}
