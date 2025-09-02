package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.NumericFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.numericfield.NumericFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

@ApplicationScoped
public class NumericFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<NumericFieldValue, NumericFieldValueDTO> {

    @Override
    public NumericFieldValueDTO mapToDTO(NumericFieldValue fieldValue, Long caseId) {
        return new NumericFieldValueDTO(
                caseId,
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getNumericValue()
        );
    }
}
