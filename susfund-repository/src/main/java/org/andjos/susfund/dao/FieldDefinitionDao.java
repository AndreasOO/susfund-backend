package org.andjos.susfund.dao;

import org.andjos.susfund.entity.field.definition.FieldDefinition;

import java.util.List;

public interface FieldDefinitionDao {
    FieldDefinition getFieldDefinitionById(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
    FieldDefinition saveFieldDefinition(FieldDefinition fieldDefinition);
}
