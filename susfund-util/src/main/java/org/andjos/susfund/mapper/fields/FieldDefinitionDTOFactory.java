package org.andjos.susfund.mapper.fields;

import org.andjos.susfund.dto.fielddefinition.BudgetFieldDefinitionDTO;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fielddefinition.SelectableFieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.SelectableValueDTO;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.definition.budget.BudgetFieldDefinition;
import org.andjos.susfund.entity.field.definition.selectable.SelectableFieldDefinition;

import java.util.stream.Collectors;

public interface FieldDefinitionDTOFactory {

    default FieldDefinitionDTO createFieldDefinitionDTO(FieldDefinition fieldDef) {
        return new FieldDefinitionDTO(
                fieldDef.getId(),
                fieldDef.getTitle(),
                fieldDef.getPreamble(),
                fieldDef.getAssistingText(),
                fieldDef.isHasComment(),
                fieldDef.getSection(),
                fieldDef.getSubSection(),
                fieldDef.getFieldType(),
                fieldDef.getFrontendLocation(),
                fieldDef.getRowIndex()
        );
    }

    default SelectableFieldDefinitionDTO createSelectableFieldDefinitionDTO(SelectableFieldDefinition fieldDef) {
        return new SelectableFieldDefinitionDTO(
                fieldDef.getId(),
                fieldDef.getTitle(),
                fieldDef.getPreamble(),
                fieldDef.getAssistingText(),
                fieldDef.isHasComment(),
                fieldDef.getSection(),
                fieldDef.getSubSection(),
                fieldDef.getFieldType(),
                fieldDef.getFrontendLocation(),
                fieldDef.getRowIndex(),
                fieldDef.getSelectableValues().stream()
                        .map(slv -> new SelectableValueDTO(slv.getId(), slv.getValue(), slv.getSelectableType()))
                        .collect(Collectors.toSet())
        );
    }

    default BudgetFieldDefinitionDTO createBudgetFieldDefinitionDTO(BudgetFieldDefinition fieldDef) {
        return new BudgetFieldDefinitionDTO(
                fieldDef.getId(),
                fieldDef.getTitle(),
                fieldDef.getPreamble(),
                fieldDef.getAssistingText(),
                fieldDef.isHasComment(),
                fieldDef.getSection(),
                fieldDef.getSubSection(),
                fieldDef.getFieldType(),
                fieldDef.getFrontendLocation(),
                fieldDef.getRowIndex(),
                fieldDef.getBudgetType()
        );
    }
}
