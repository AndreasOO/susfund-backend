package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.TextFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.textfield.TextFieldValue;

@ApplicationScoped
public class TextFieldValueMapper
        implements FieldValueMapper<TextFieldValue, TextFieldValueDTO>,
                   BaseFieldDefinitionMapper {

    @Override
    public TextFieldValueDTO mapToDTO(TextFieldValue fieldValue) {
        return new TextFieldValueDTO(
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getStringValue()
        );
    }
}