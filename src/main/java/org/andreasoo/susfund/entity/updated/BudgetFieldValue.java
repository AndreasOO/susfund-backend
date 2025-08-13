package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue(value="BUDGET")
public class BudgetFieldValue extends AbstractFieldValue<BudgetFieldDefinition>{

    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY)
    List<FinancingRow> financingRows;

    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY)
    List<BudgetRow> budgetRows;

    @Column(name="total_financing_ratio")
    int totalFinancingRatio;

    String stringValue;

    @Override
    public String getValueAsString() {
        return "";
    }
}
