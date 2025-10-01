package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;

import java.time.LocalDate;

public class DateFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private LocalDate dateValue;

    public DateFieldValueDTO() {
        super();
    }

    protected DateFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "dateFieldValue");
    }

    public DateFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, LocalDate dateValue) {
        super(id, owningCaseId, owningFieldDefinition, "dateFieldValue");
        this.dateValue = dateValue;
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }
}
