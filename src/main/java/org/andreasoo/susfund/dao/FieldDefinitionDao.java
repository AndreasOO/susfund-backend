package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;

import java.util.List;

public interface FieldDefinitionDao {
    FieldDefinition getFieldDefinitionById(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
    FieldDefinition saveFieldDefinition(FieldDefinition fieldDefinition);
}
