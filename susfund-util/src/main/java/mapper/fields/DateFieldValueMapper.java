package mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.DateFieldValueDTO;
import entity.field.value.datefield.DateFieldValue;

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
