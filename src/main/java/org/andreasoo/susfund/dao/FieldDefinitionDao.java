package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.updated.FieldDefinition;

import java.util.List;

public interface FieldDefinitionDao {
    FieldDefinition getFieldDefinitionById(Long id);
    List<FieldDefinition> getAllFieldDefinitionByCaseId(Long id);

    FieldDefinition saveFieldDefinition(FieldDefinition fieldDefinition);
}
