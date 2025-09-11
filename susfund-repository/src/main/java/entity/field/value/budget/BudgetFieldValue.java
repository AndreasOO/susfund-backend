package entity.field.value.budget;

import jakarta.persistence.*;
import entity.caseentity.CaseEntity;
import entity.field.definition.budget.BudgetFieldDefinition;
import entity.field.value.AbstractFieldValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value="BUDGET")
public class BudgetFieldValue extends AbstractFieldValue<BudgetFieldDefinition> {

    public BudgetFieldValue() {
        super();
    }

    public BudgetFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

//    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FinancingRow> financingRows = new ArrayList<>();

//    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "owningBudget", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<BudgetRow> budgetRows = new ArrayList<>();

    @Column(name="total_financing_ratio")
    int totalFinancingRatio;


    @Override
    public String getValueAsString() {
        return "";
    }

    public List<FinancingRow> getFinancingRows() {
        return financingRows;
    }

    public void setFinancingRows(List<FinancingRow> financingRows) {
        this.financingRows = financingRows;
    }

    public List<BudgetRow> getBudgetRows() {
        return budgetRows;
    }

    public void setBudgetRows(List<BudgetRow> budgetRows) {
        this.budgetRows = budgetRows;
    }

    public int getTotalFinancingRatio() {
        return totalFinancingRatio;
    }

    public void setTotalFinancingRatio(int totalFinancingRatio) {
        this.totalFinancingRatio = totalFinancingRatio;
    }
}
