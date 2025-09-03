package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;

import java.util.List;

public class BudgetFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Integer totalFinancingRatio;
    private List<FinancingRowDTO> financingRows;
    private List<BudgetRowDTO> budgetRows;

    protected BudgetFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition, "budgetFieldValue");
    }

    public BudgetFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Integer totalFinancingRatio, List<FinancingRowDTO> financingRows, List<BudgetRowDTO> budgetRows) {
        super(owningCaseId, owningFieldDefinition,  "budgetFieldValue");
        this.totalFinancingRatio = totalFinancingRatio;
        this.financingRows = financingRows;
        this.budgetRows = budgetRows;
    }

    public Integer getTotalFinancingRatio() {
        return totalFinancingRatio;
    }

    public void setTotalFinancingRatio(Integer totalFinancingRatio) {
        this.totalFinancingRatio = totalFinancingRatio;
    }

    public List<FinancingRowDTO> getFinancingRows() {
        return financingRows;
    }

    public void setFinancingRows(List<FinancingRowDTO> financingRows) {
        this.financingRows = financingRows;
    }

    public List<BudgetRowDTO> getBudgetRows() {
        return budgetRows;
    }

    public void setBudgetRows(List<BudgetRowDTO> budgetRows) {
        this.budgetRows = budgetRows;
    }
}
