package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

@Entity
@Table(name="budget_row")
public class BudgetRow {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="estimated_cost")
    int estimatedCost;

    @Column(name="cost_type")
    @Enumerated(EnumType.STRING)
    CostType costType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="field_value_entity_id")
    BudgetFieldValue owningBudget;

}
