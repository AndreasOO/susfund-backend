package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.TextFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.textfield.TextFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

@ApplicationScoped
public class TextFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<TextFieldValue, TextFieldValueDTO> {

    @Override
    public TextFieldValueDTO mapToDTO(TextFieldValue fieldValue, Long caseId) {
        return new TextFieldValueDTO(
                caseId,
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getStringValue()
        );
    }
}