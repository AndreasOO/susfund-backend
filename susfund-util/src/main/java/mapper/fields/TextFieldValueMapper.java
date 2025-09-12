package mapper.fields;

import dto.fieldvalue.TextFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.textfield.TextFieldValue;

@ApplicationScoped
public class TextFieldValueMapper
        implements FieldValueMapper<TextFieldValue, TextFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public TextFieldValueDTO mapToDTO(TextFieldValue fieldValue) {
        return new TextFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getStringValue()
        );
    }
}