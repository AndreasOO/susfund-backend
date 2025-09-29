package org.andjos.susfund.service;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.definition.selectable.SelectableValue;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

import java.util.List;


public interface FieldDefinitionService {
    FieldDefinition createFieldDefinition(FieldDefinition fieldDefinition);
    FieldDefinition getFieldDefinition(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
    List<SelectableValue> createSelectableValues(List<SelectableValue> selectableValues);
    List<SelectableValue> getAllSelectableValues();
    List<AbstractFieldValue<? extends FieldDefinition>> saveFields(List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fieldValues);
}
