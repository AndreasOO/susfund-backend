package org.andjos.susfund.service.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldDefinitionDao;
import org.andjos.susfund.dao.SelectableValueDao;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.definition.selectable.SelectableValue;
import org.andjos.susfund.service.FieldDefinitionService;

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
