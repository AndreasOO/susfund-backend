package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.OrganizationDTO;

public class FinancingRowDTO {

    private OrganizationDTO organization;
    private int financingAmount;
    private int financingPercentage;
    private Long id;

    public FinancingRowDTO(){}

    public FinancingRowDTO(Long id, OrganizationDTO organization, int financingAmount, int financingPercentage) {
        this.id = id;
        this.organization = organization;
        this.financingAmount = financingAmount;
        this.financingPercentage = financingPercentage;
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
}
