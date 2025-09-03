package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.AbstractDTO;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;

public abstract class AbstractFieldValueDTO<T extends FieldDefinitionDTO> extends AbstractDTO {

    public final Long owningCaseId;
    public final FieldDefinitionDTO owningFieldDefinition;

    protected AbstractFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, String dtoClassName) {
        super(dtoClassName);
        this.owningCaseId = owningCaseId;
        this.owningFieldDefinition = owningFieldDefinition;
    }

    public Long getOwningCaseId() {
        return owningCaseId;
    }

    public FieldDefinitionDTO getOwningFieldDefinition() {
        return owningFieldDefinition;
    }
}
