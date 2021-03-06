package io.easyware.platypus.api.fin.objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {

    public Expense() {
        // DEFAULT CONSTRUCTOR
    }

    @Id
    private int id;

    @NotBlank
    @Column(name = "expenses_groups_id")
    private int expensesGroupId;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "cost_center_id")
    private CostCenter costCenter;

    @NotBlank
    @Column(name = "value")
    private double value;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpensesGroupId() {
        return expensesGroupId;
    }

    public void setExpensesGroupId(int expensesGroupId) {
        this.expensesGroupId = expensesGroupId;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
