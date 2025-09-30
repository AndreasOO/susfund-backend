package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;

public class TextFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private String stringValue;

    public TextFieldValueDTO() {
        super();
    }

    protected TextFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "textFieldValue");
    }

    public TextFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, String stringValue) {
        super(id, owningCaseId, owningFieldDefinition, "textFieldValue");
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
