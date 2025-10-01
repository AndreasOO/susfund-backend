package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.OrganizationDTO;
import org.andjos.susfund.entity.field.value.budget.FinancingType;

public class FinancingRowDTO {

    private Long id;
    private OrganizationDTO organization;
    private int financingAmount;
    private int financingPercentage;
    private FinancingType financingType;

    public FinancingRowDTO(){

    }

    public FinancingRowDTO(Long id, OrganizationDTO organization, int financingAmount, int financingPercentage, FinancingType financingType) {

        this.id = id;
        this.organization = organization;
        this.financingAmount = financingAmount;
        this.financingPercentage = financingPercentage;
        this.financingType = financingType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }

    public int getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(int financingAmount) {
        this.financingAmount = financingAmount;
    }

    public int getFinancingPercentage() {
        return financingPercentage;
    }

    public void setFinancingPercentage(int financingPercentage) {
        this.financingPercentage = financingPercentage;
    }

    public FinancingType getFinancingType() {
        return financingType;
    }

    public void setFinancingType(FinancingType financingType) {
        this.financingType = financingType;
    }
}
