package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.OrganizationDTO;
import org.andjos.susfund.dto.fieldvalue.BudgetFieldValueDTO;
import org.andjos.susfund.dto.fieldvalue.BudgetRowDTO;
import org.andjos.susfund.dto.fieldvalue.FinancingRowDTO;
import org.andjos.susfund.entity.field.value.budget.BudgetFieldValue;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.budget.BudgetRow;
import org.andjos.susfund.entity.field.value.budget.FinancingRow;
import org.andjos.susfund.entity.organization.Organization;

import java.util.stream.Collectors;


@ApplicationScoped
public class BudgetFieldValueMapper
        implements FieldValueMapper<BudgetFieldValue, BudgetFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

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


    @Override
    public BudgetFieldValue mapToEntity(BudgetFieldValueDTO dto) {
        BudgetFieldValue budgetFieldValue = (BudgetFieldValue) fieldValueDao.findById(dto.getId());

        budgetFieldValue.setTotalFinancingRatio(dto.getTotalFinancingRatio());

//        budgetFieldValue.setBudgetRows(dto.getBudgetRows().stream()
//                                                          .map(row -> new BudgetRow(
//                                                                                                 row.getId(),
//                                                                                                 budgetFieldValue,
//                                                                                                 row.getEstimatedCost(),
//                                                                                                 row.getCostType(),
//                                                                                                 row.getAccruedCost(),
//                                                                                                 row.getDescription()))
//                                                                   .collect(Collectors.toList()));
        budgetFieldValue.getBudgetRows().clear();
        budgetFieldValue.getBudgetRows().addAll(
                dto.getBudgetRows().stream()
                        .map(row -> new BudgetRow(
                                row.getId(),
                                budgetFieldValue,
                                row.getEstimatedCost(),
                                row.getCostType(),
                                row.getAccruedCost(),
                                row.getDescription()))
                        .collect(Collectors.toList())
        );

//        budgetFieldValue.setFinancingRows(dto.getFinancingRows().stream()
//                                                                .map(row -> new FinancingRow(
//                                                                        row.getId(),
//                                                                        budgetFieldValue,
//                                                                        new Organization(row.getOrganization().getId(),
//                                                                                         row.getOrganization().getName(),
//                                                                                         row.getOrganization().getOrganizationType()),
//                                                                        row.getFinancingAmount(),
//                                                                        row.getFinancingPercentage(),
//                                                                        row.getFinancingType()))
//                                                                .collect(Collectors.toList()));
        budgetFieldValue.getFinancingRows().clear();
        budgetFieldValue.getFinancingRows().addAll(
                dto.getFinancingRows().stream()
                        .map(row -> new FinancingRow(
                                row.getId(),
                                budgetFieldValue,
                                new Organization(
                                        row.getOrganization().getId(),
                                        row.getOrganization().getName(),
                                        row.getOrganization().getOrganizationType()),
                                row.getFinancingAmount(),
                                row.getFinancingPercentage(),
                                row.getFinancingType()))
                        .collect(Collectors.toList())
        );

        return budgetFieldValue;
    }
}
