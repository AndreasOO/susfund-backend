package org.andjos.susfund.mapper.fields;

import org.andjos.susfund.dto.fieldvalue.DateFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.datefield.DateFieldValue;

@ApplicationScoped
public class DateFieldValueMapper
        implements FieldValueMapper<DateFieldValue, DateFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public DateFieldValueDTO mapToDTO(DateFieldValue fieldValue) {
        return new DateFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDateValue()
        );
    }
}
