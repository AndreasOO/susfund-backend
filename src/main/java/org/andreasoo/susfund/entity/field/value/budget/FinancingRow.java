package org.andreasoo.susfund.entity.field.value.budget;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.organization.Organization;

@Entity
@Table(name="financing_row")
public class FinancingRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="organization_id")
    Organization organization;

    @Column(name="financing_amount")
    int financingAmount;

    @Column(name="financing_percentage")
    int financingPercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="field_value_entity_id")
    BudgetFieldValue owningBudget;

    @Enumerated(EnumType.STRING)
    @Column(name="financing_type")
    private FinancingType financingType;

    public FinancingRow(){

    }

    public FinancingRow(BudgetFieldValue owningBudget, Organization organization, int financingAmount, int financingPercentage, FinancingType financingType) {
        this.organization = organization;
        this.financingAmount = financingAmount;
        this.financingPercentage = financingPercentage;
        this.owningBudget = owningBudget;
        this.financingType = financingType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
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

    public BudgetFieldValue getOwningBudget() {
        return owningBudget;
    }

    public void setOwningBudget(BudgetFieldValue owningBudget) {
        this.owningBudget = owningBudget;
    }

    public FinancingType getFinancingType() {
        return financingType;
    }

    public void setFinancingType(FinancingType financingType) {
        this.financingType = financingType;
    }
}
