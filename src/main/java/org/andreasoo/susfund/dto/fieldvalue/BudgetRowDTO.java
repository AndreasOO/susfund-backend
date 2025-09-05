package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.AbstractDTO;
import org.andreasoo.susfund.dto.OrganizationDTO;
import org.andreasoo.susfund.entity.updated.field.value.budget.CostType;

public class BudgetRowDTO extends AbstractDTO {

    private int estimatedCost;
    private CostType costType;
    private int accruedCost;
    private Long id;
    private String description;

    public BudgetRowDTO(){
        super("budgetRowDTO");
    }

    public BudgetRowDTO(Long id, int estimatedCost, CostType costType, int accruedCost, String description) {
        super("budgetRowDTO");
        this.id = id;
        this.estimatedCost = estimatedCost;
        this.costType = costType;
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

    public int getAccruedCost() {
        return accruedCost;
    }

    public void setAccruedCost(int accruedCost) {
        this.accruedCost = accruedCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
