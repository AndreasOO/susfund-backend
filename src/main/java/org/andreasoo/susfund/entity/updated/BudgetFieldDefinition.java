package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value="BUDGET")
public class BudgetFieldDefinition extends FieldDefinition {

    @Column(name="budget_type")
    @Enumerated(EnumType.STRING)
    BudgetType budgetType;

}
