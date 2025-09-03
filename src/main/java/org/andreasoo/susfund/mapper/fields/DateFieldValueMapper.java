package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.DateFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.datefield.DateFieldValue;

@ApplicationScoped
public class DateFieldValueMapper
        implements FieldValueMapper<DateFieldValue, DateFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public DateFieldValueDTO mapToDTO(DateFieldValue fieldValue) {
        return new DateFieldValueDTO(
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDateValue()
        );
    }
}
