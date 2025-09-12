package mapper.fields;

import dto.fielddefinition.BudgetFieldDefinitionDTO;
import dto.fielddefinition.FieldDefinitionDTO;
import dto.fielddefinition.SelectableFieldDefinitionDTO;
import dto.fieldvalue.SelectableValueDTO;
import entity.field.definition.FieldDefinition;
import entity.field.definition.budget.BudgetFieldDefinition;
import entity.field.definition.selectable.SelectableFieldDefinition;

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
