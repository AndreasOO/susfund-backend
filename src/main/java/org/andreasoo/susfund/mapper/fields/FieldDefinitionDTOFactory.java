package org.andreasoo.susfund.mapper.fields;

import org.andreasoo.susfund.dto.fielddefinition.BudgetFieldDefinitionDTO;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fielddefinition.SelectableFieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.SelectableValueDTO;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.selectable.SelectableFieldDefinition;

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
