package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.NumericFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.numericfield.NumericFieldValue;

@ApplicationScoped
public class NumericFieldValueMapper
        implements FieldValueMapper<NumericFieldValue, NumericFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public NumericFieldValueDTO mapToDTO(NumericFieldValue fieldValue) {
        return new NumericFieldValueDTO(
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getNumericValue()
        );
    }
}
