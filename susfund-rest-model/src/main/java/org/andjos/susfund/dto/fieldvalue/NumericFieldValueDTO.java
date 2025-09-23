package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;

public class NumericFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Integer numericValue;

    protected NumericFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "numericFieldValue");
    }

    public NumericFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Integer numericValue) {
        super(id, owningCaseId, owningFieldDefinition, "numericFieldValue");
        this.numericValue = numericValue;
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Integer numericValue) {
        this.numericValue = numericValue;
    }
}
