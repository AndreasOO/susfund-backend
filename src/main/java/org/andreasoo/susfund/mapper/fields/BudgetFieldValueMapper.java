package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.OrganizationDTO;
import org.andreasoo.susfund.dto.fieldvalue.BudgetFieldValueDTO;
import org.andreasoo.susfund.dto.fieldvalue.BudgetRowDTO;
import org.andreasoo.susfund.dto.fieldvalue.FinancingRowDTO;
import org.andreasoo.susfund.entity.updated.field.value.budget.BudgetFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

@ApplicationScoped
public class BudgetFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<BudgetFieldValue, BudgetFieldValueDTO> {

    @Override
    public BudgetFieldValueDTO mapToDTO(BudgetFieldValue fieldValue, Long caseId) {
        return new BudgetFieldValueDTO(
                caseId,
                createBudgetFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getTotalFinancingRatio(),
                fieldValue.getFinancingRows().stream()
                        .map(row -> new FinancingRowDTO(
                                row.getId(),
                                new OrganizationDTO(row.getOrganization().getId(),
                                        row.getOrganization().getName(),
                                        row.getOrganization().getOrganizationType().getName()),
                                row.getFinancingAmount(),
                                row.getFinancingPercentage()))
                        .toList(),
                fieldValue.getBudgetRows().stream()
                        .map(row -> new BudgetRowDTO(
                                row.getId(),
                                row.getEstimatedCost(),
                                row.getCostType(),
                                row.getAccruedCost()))
                        .toList()
        );
    }
}
