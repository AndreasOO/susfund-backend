package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

public class TextFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private String stringValue;

    protected TextFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition, "textFieldValue");
    }

    public TextFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, String stringValue) {
        super(owningCaseId, owningFieldDefinition, "textFieldValue");
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
