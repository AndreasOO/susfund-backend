package org.andreasoo.susfund.entity.updated.field.definition.budget;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;

@Entity
@DiscriminatorValue(value="BUDGET")
public class BudgetFieldDefinition extends FieldDefinition {

    public BudgetFieldDefinition() {
        super();
    }

    @Column(name="budget_type")
    @Enumerated(EnumType.STRING)
    BudgetType budgetType;


    public BudgetType getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(BudgetType budgetType) {
        this.budgetType = budgetType;
    }
}
