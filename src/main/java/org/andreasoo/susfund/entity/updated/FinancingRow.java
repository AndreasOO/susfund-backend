package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.old.Organization;

@Entity
public class FinancingRow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}
