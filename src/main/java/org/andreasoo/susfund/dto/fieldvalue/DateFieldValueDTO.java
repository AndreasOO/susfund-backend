package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;

import java.time.LocalDate;

public class DateFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private LocalDate dateValue;

    protected DateFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition, "dateFieldValue");
    }

    public DateFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, LocalDate dateValue) {
        super(owningCaseId, owningFieldDefinition, "dateFieldValue");
        this.dateValue = dateValue;
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }
}
