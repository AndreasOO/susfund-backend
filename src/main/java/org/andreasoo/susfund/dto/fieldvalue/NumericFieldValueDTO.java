package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;

public class NumericFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Integer numericValue;

    protected NumericFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition);
    }

    public NumericFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Integer numericValue) {
        super(owningCaseId, owningFieldDefinition);
        this.numericValue = numericValue;
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Integer numericValue) {
        this.numericValue = numericValue;
    }
}
