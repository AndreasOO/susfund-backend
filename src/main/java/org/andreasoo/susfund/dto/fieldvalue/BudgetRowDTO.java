package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.OrganizationDTO;
import org.andreasoo.susfund.entity.updated.field.value.budget.CostType;

public class BudgetRowDTO {

    private OrganizationDTO organization;
    private int estimatedCost;
    private CostType costType;
    private int accruedCost;

    public BudgetRowDTO(){}

    public BudgetRowDTO(OrganizationDTO organization, int estimatedCost, CostType costType, int accruedCost) {
        this.organization = organization;
        this.estimatedCost = estimatedCost;
        this.costType = costType;
        this.accruedCost = accruedCost;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
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
}
