package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionResultType;

public class DecisionFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private DecisionResultType decisionResultType;

    protected DecisionFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition, "decisionFieldValue");
    }

    public DecisionFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, DecisionResultType decisionResultType) {
        super(owningCaseId, owningFieldDefinition, "decisionFieldValue");
        this.decisionResultType = decisionResultType;
    }

    public DecisionResultType getDecisionResultType() {
        return decisionResultType;
    }

    public void setDecisionResultType(DecisionResultType decisionResultType) {
        this.decisionResultType = decisionResultType;
    }
}
