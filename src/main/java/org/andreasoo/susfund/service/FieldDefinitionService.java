package org.andreasoo.susfund.service;

import org.andreasoo.susfund.entity.updated.FieldDefinition;

import java.util.List;


public interface FieldDefinitionService {
    FieldDefinition createFieldDefinition(FieldDefinition fieldDefinition);
    FieldDefinition getFieldDefinition(Long id);
    List<FieldDefinition> getAllFieldDefinitions();
}
