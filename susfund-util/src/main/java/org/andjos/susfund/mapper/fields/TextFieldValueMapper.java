package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.TextFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.textfield.TextFieldValue;

@ApplicationScoped
public class TextFieldValueMapper
        implements FieldValueMapper<TextFieldValue, TextFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

    @Override
    public TextFieldValueDTO mapToDTO(TextFieldValue fieldValue) {
        return new TextFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getStringValue()
        );
    }


    @Override
    public TextFieldValue mapToEntity(TextFieldValueDTO dto) {
        TextFieldValue textFieldValue = (TextFieldValue) fieldValueDao.findById(dto.getId());
        textFieldValue.setStringValue(dto.getStringValue());
        return textFieldValue;
    }
}