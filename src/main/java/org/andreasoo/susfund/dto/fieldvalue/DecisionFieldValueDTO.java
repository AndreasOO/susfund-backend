package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionResultType;

public class DecisionFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private DecisionResultType decisionResultType;

    private String motivation;

    protected DecisionFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "decisionFieldValue");
    }

    public DecisionFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, DecisionResultType decisionResultType, String motivation) {
        super(id, owningCaseId, owningFieldDefinition, "decisionFieldValue");
        this.decisionResultType = decisionResultType;
        this.motivation = motivation;
    }

    public DecisionResultType getDecisionResultType() {
        return decisionResultType;
    }

    public void setDecisionResultType(DecisionResultType decisionResultType) {
        this.decisionResultType = decisionResultType;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}
