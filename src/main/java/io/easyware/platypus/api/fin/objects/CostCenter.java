package io.easyware.platypus.api.fin.objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "cost_centers")
public class CostCenter {

    public CostCenter() {}

    @Id
    @Column(name="id")
    private int id;

    @Column(name="parent_id")
    private int parentId;

    //@NotBlank
    @Column(name="domain_id")
    private int domainId;

    @NotBlank
    @Size(max=45)
    @Column(name="name")
    private String name;

    //@NotBlank
    @Column(name="is_active")
    private boolean isActive;

    @Transient
    private List<CostCenter> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<CostCenter> getChildren() {
        return children;
    }

    public void setChildren(List<CostCenter> children) {
        this.children = children;
    }
}
