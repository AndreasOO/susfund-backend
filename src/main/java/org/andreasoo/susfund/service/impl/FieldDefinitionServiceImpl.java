package org.andreasoo.susfund.service.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.FieldDefinitionDao;
import org.andreasoo.susfund.dao.SelectableValueDao;
import org.andreasoo.susfund.entity.updated.FieldDefinition;
import org.andreasoo.susfund.entity.updated.SelectableValue;
import org.andreasoo.susfund.service.FieldDefinitionService;

import java.util.List;

@ApplicationScoped
public class FieldDefinitionServiceImpl implements FieldDefinitionService {


    @Inject
    FieldDefinitionDao fieldDefinitionDao;

    @Inject
    SelectableValueDao selectableValueDao;

    public FieldDefinition createFieldDefinition(FieldDefinition fieldDefinition) {
        return fieldDefinitionDao.saveFieldDefinition(fieldDefinition);
    }


    public FieldDefinition getFieldDefinition(Long id) {
        return fieldDefinitionDao.getFieldDefinitionById(id);
    }

    public List<FieldDefinition> getAllFieldDefinitions() {
        return fieldDefinitionDao.getAllFieldDefinitions();
    }
    public List<SelectableValue> createSelectableValues(List<SelectableValue> selectableValues) {
        return selectableValueDao.saveSelectableValues(selectableValues);
    }

    public List<SelectableValue> getAllSelectableValues() {
        return selectableValueDao.getAllSelectableValues();
    }

}
