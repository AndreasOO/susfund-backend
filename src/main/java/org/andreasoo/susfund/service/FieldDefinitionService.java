package org.andreasoo.susfund.service;

import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.selectable.SelectableValue;

import java.util.List;


public interface FieldDefinitionService {
    FieldDefinition createFieldDefinition(FieldDefinition fieldDefinition);
    FieldDefinition getFieldDefinition(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
    List<SelectableValue> createSelectableValues(List<SelectableValue> selectableValues);
    List<SelectableValue> getAllSelectableValues();
}
