package org.andjos.susfund.service.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldDefinitionDao;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dao.SelectableValueDao;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.definition.selectable.SelectableValue;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import org.andjos.susfund.mapperservice.GeneralMappingService;
import org.andjos.susfund.service.FieldDefinitionService;

import java.util.List;

@ApplicationScoped
public class FieldDefinitionServiceImpl implements FieldDefinitionService {


    @Inject
    GeneralMappingService generalMappingService;

    @Inject
    FieldDefinitionDao fieldDefinitionDao;

    @Inject
    SelectableValueDao selectableValueDao;

    @Inject
    FieldValueDao fieldValueDao;


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

    public List<AbstractFieldValue<? extends FieldDefinition>> saveFields(List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fieldValues) {
        return fieldValues.stream().map( dto -> {

        })
    }

}
