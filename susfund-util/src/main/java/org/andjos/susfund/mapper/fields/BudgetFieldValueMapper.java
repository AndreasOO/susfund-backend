package org.andjos.susfund.mapper.fields;

import org.andjos.susfund.dto.OrganizationDTO;
import org.andjos.susfund.dto.fieldvalue.BudgetFieldValueDTO;
import org.andjos.susfund.dto.fieldvalue.BudgetRowDTO;
import org.andjos.susfund.dto.fieldvalue.FinancingRowDTO;
import org.andjos.susfund.entity.field.value.budget.BudgetFieldValue;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BudgetFieldValueMapper
        implements FieldValueMapper<BudgetFieldValue, BudgetFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public BudgetFieldValueDTO mapToDTO(BudgetFieldValue fieldValue) {
        return new BudgetFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createBudgetFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getTotalFinancingRatio(),
                fieldValue.getFinancingRows().stream()
                        .map(row -> new FinancingRowDTO(
                                row.getId(),
                                new OrganizationDTO(row.getOrganization().getId(),
                                        row.getOrganization().getName(),
                                        row.getOrganization().getOrganizationType()),
                                row.getFinancingAmount(),
                                row.getFinancingPercentage(),
                                row.getFinancingType()))
                        .toList(),
                fieldValue.getBudgetRows().stream()
                        .map(row -> new BudgetRowDTO(
                                row.getId(),
                                row.getEstimatedCost(),
                                row.getCostType(),
                                row.getAccruedCost(),
                                row.getDescription()))
                        .toList()
        );
    }
}
