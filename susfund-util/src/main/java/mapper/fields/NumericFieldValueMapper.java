package mapper.fields;

import dto.fieldvalue.NumericFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import entity.field.value.numericfield.NumericFieldValue;

@ApplicationScoped
public class NumericFieldValueMapper
        implements FieldValueMapper<NumericFieldValue, NumericFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public NumericFieldValueDTO mapToDTO(NumericFieldValue fieldValue) {
        return new NumericFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getNumericValue()
        );
    }
}
