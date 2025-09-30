package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.DateFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.datefield.DateFieldValue;

@ApplicationScoped
public class DateFieldValueMapper
        implements FieldValueMapper<DateFieldValue, DateFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

    @Override
    public DateFieldValueDTO mapToDTO(DateFieldValue fieldValue) {
        return new DateFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDateValue()
        );
    }


    @Override
    public DateFieldValue mapToEntity(DateFieldValueDTO dto) {
        DateFieldValue dateFieldValue = (DateFieldValue) fieldValueDao.findById(dto.getId());
        dateFieldValue.setDateValue(dto.getDateValue());
        return dateFieldValue;
    }
}
