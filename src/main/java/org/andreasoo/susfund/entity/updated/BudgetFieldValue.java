package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue(value="BUDGET")
public class BudgetFieldValue extends AbstractFieldValue<BudgetFieldDefinition>{

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="field_value_entity_id")
    List<FinancingRow> financingRows;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="field_value_entity_id")
    List<BudgetRow> budgetRows;

    @Column(name="total_financing_ratio")
    int totalFinancingRatio;

    String stringValue;

    @Override
    public String getValueAsString() {
        return "";
    }
}
