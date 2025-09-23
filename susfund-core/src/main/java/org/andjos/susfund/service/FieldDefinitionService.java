package org.andjos.susfund.service;

import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.definition.selectable.SelectableValue;

import java.util.List;


public interface FieldDefinitionService {
    FieldDefinition createFieldDefinition(FieldDefinition fieldDefinition);
    FieldDefinition getFieldDefinition(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
    List<SelectableValue> createSelectableValues(List<SelectableValue> selectableValues);
    List<SelectableValue> getAllSelectableValues();
}
