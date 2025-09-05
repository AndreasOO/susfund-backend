package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

@Entity
@Table(name="financing")
public class Financing {

    @Id
    int id;

    @ManyToOne
    @JoinColumn(name="organization_id")
    Organization organization;

    @Column(name="estimated_financing_in_percentage")
    int estimatedFinancingInPercentage;

    @Column(name="estimated_financing_in_money")
    int estimatedFinancingInMoney;

    @ManyToOne
    @JoinColumn(name="financing_type_id")
    FinancingType financingType;

    public Financing() {
    }

    public Financing(int id, Organization organization, int estimatedFinancingInPercentage, int estimatedFinancingInMoney, FinancingType financingType) {
        this.id = id;
        this.organization = organization;
        this.estimatedFinancingInPercentage = estimatedFinancingInPercentage;
        this.estimatedFinancingInMoney = estimatedFinancingInMoney;
        this.financingType = financingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getEstimatedFinancingInPercentage() {
        return estimatedFinancingInPercentage;
    }

    public void setEstimatedFinancingInPercentage(int estimatedFinancingInPercentage) {
        this.estimatedFinancingInPercentage = estimatedFinancingInPercentage;
    }

    public int getEstimatedFinancingInMoney() {
        return estimatedFinancingInMoney;
    }

    public void setEstimatedFinancingInMoney(int estimatedFinancingInMoney) {
        this.estimatedFinancingInMoney = estimatedFinancingInMoney;
    }

    public FinancingType getFinancingType() {
        return financingType;
    }

    public void setFinancingType(FinancingType financingType) {
        this.financingType = financingType;
    }
}
