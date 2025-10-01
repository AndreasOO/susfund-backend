package org.andjos.susfund.entity.field.value.budget;

import jakarta.persistence.*;

@Entity
@Table(name="budget_row")
public class BudgetRow {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="estimated_cost")
    int estimatedCost;

    @Column(name="cost_type")
    @Enumerated(EnumType.STRING)
    CostType costType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="field_value_entity_id")
    BudgetFieldValue owningBudget;

    @Column(name="accrued_cost")
    int accruedCost;

    private String description;

    public BudgetRow(){

    }

    public BudgetRow(BudgetFieldValue owningBudget, int estimatedCost, CostType costType, int accruedCost, String description) {
        this.estimatedCost = estimatedCost;
        this.costType = costType;
        this.owningBudget = owningBudget;
        this.accruedCost = accruedCost;
        this.description = description;
    }

    public BudgetRow(Long id, BudgetFieldValue owningBudget, int estimatedCost, CostType costType, int accruedCost, String description) {
        this.id = id;
        this.estimatedCost = estimatedCost;
        this.costType = costType;
        this.owningBudget = owningBudget;
        this.accruedCost = accruedCost;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public CostType getCostType() {
        return costType;
    }

    public void setCostType(CostType costType) {
        this.costType = costType;
    }

    public BudgetFieldValue getOwningBudget() {
        return owningBudget;
    }

    public int getAccruedCost() {
        return accruedCost;
    }

    public void setAccruedCost(int accruedCost) {
        this.accruedCost = accruedCost;
    }

    public void setOwningBudget(BudgetFieldValue owningBudget) {
        this.owningBudget = owningBudget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
