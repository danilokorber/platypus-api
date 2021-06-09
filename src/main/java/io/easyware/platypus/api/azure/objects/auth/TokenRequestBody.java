package io.easyware.platypus.api.azure.objects.auth;

import javax.ws.rs.core.Form;

public class TokenRequestBody {
    public TokenRequestBody() {}

    public String grant_type = "client_credentials";
    public String client_id = "9e6b15f8-f663-48cb-b75a-67dbf853af32";
    public String client_secret = "Sq.4GSEC3jCt2hbtN9rh~4_W1Sf3fbzMnX";
    public String resource = "https://management.azure.com/";

    public Form getBody() {
        return new Form()
                .param("grant_type", grant_type)
                .param("client_id", client_id)
                .param("client_secret", client_secret)
                .param("resource", resource);
    }
}
