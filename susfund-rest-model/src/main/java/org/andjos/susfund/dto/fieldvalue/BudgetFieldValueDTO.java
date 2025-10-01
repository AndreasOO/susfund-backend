package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;

import java.util.List;

public class BudgetFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Integer totalFinancingRatio;
    private List<FinancingRowDTO> financingRows;
    private List<BudgetRowDTO> budgetRows;

    public BudgetFieldValueDTO() {
        super();
    }

    protected BudgetFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "budgetFieldValue");
    }

    public BudgetFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Integer totalFinancingRatio, List<FinancingRowDTO> financingRows, List<BudgetRowDTO> budgetRows) {
        super(id, owningCaseId, owningFieldDefinition,  "budgetFieldValue");
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
