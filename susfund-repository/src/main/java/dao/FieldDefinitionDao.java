package dao;

import entity.field.definition.FieldDefinition;

import java.util.List;

public interface FieldDefinitionDao {
    FieldDefinition getFieldDefinitionById(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
    FieldDefinition saveFieldDefinition(FieldDefinition fieldDefinition);
}
