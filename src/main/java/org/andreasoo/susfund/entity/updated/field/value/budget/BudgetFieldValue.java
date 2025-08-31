package org.andreasoo.susfund.entity.updated.field.value.budget;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

import java.util.List;

@Entity
@DiscriminatorValue(value="BUDGET")
public class BudgetFieldValue extends AbstractFieldValue<BudgetFieldDefinition> {

    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY)
    List<FinancingRow> financingRows;

    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY)
    List<BudgetRow> budgetRows;

    @Column(name="total_financing_ratio")
    int totalFinancingRatio;

    @Override
    public String getValueAsString() {
        return "";
    }
}
