package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.DateFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.datefield.DateFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

@ApplicationScoped
public class DateFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<DateFieldValue, DateFieldValueDTO> {

    @Override
    public DateFieldValueDTO mapToDTO(DateFieldValue fieldValue, Long caseId) {
        return new DateFieldValueDTO(
                caseId,
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDateValue()
        );
    }
}
