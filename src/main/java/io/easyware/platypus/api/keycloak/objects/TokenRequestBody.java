package io.easyware.platypus.api.keycloak.objects;

import javax.ws.rs.core.Form;

public class TokenRequestBody {
    public TokenRequestBody() {
        this.username = "admin";
        this.password = "Danilo77";
        this.grant_type = "password";
        this.client_id = "admin-cli";
    }

    private String username;
    private String password;
    private String grant_type;
    private String client_id;

    public Form getBody() {
        return new Form()
                .param("username", username)
                .param("password", password)
                .param("grant_type", grant_type)
                .param("client_id", client_id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }
}
