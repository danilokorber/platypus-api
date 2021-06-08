package io.easyware.platypus.api.projects.objects;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "vProjects")
public class Project {

    public Project() { }

    @Id
    @Column(name = "id")
    private int id;

    @NotBlank
    @Size(max=36)
    @Column(name = "uid")
    private String domainId;

    @NotBlank
    @Size(max=20)
    private String name;

    @NotBlank
    @Column(name = "is_active")
    private boolean isActive;

    private String description;
    private float budget;

    @NotBlank
    @Size(max=3)
    private String currency;

    @NotBlank
    @Column(name = "created_at")
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date createdAt;

    @NotBlank
    @Size(max=100)
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date updatedAt;

    @Size(max=100)
    @Column(name = "updated_by")
    private String updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
