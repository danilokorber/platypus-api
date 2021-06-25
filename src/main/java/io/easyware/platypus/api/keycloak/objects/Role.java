package io.easyware.platypus.api.keycloak.objects;

import javax.ws.rs.core.Form;

public class Role {
    private String id;
    private String name;
    private String description;
    private boolean composite;
    private boolean clientRole;
    private String containerId;

    public Role() {}

    public Role(String name) {
        this(name, "");
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        composite = false;
        clientRole = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComposite() {
        return composite;
    }

    public void setComposite(boolean composite) {
        this.composite = composite;
    }

    public boolean isClientRole() {
        return clientRole;
    }

    public void setClientRole(boolean clientRole) {
        this.clientRole = clientRole;
    }

    public String getContainerId() { return containerId; }

    public void setContainerId(String containerId) { this.containerId = containerId; }
}
