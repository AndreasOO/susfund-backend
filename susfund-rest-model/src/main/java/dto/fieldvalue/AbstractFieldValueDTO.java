package dto.fieldvalue;

import dto.AbstractDTO;
import dto.fielddefinition.FieldDefinitionDTO;

public abstract class AbstractFieldValueDTO<T extends FieldDefinitionDTO> extends AbstractDTO {

    public final Long id;
    public final Long owningCaseId;
    public final FieldDefinitionDTO owningFieldDefinition;

    protected AbstractFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, String dtoClassName) {
        super(dtoClassName);
        this.id = id;
        this.owningCaseId = owningCaseId;
        this.owningFieldDefinition = owningFieldDefinition;
    }

    public Long getOwningCaseId() {
        return owningCaseId;
    }

    public FieldDefinitionDTO getOwningFieldDefinition() {
        return owningFieldDefinition;
    }

    public Long getId() {
        return id;
    }
}
