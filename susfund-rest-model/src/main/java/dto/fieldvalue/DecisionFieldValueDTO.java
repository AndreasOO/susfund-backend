package dto.fieldvalue;

import dto.fielddefinition.FieldDefinitionDTO;
import entity.field.value.decision.DecisionResultType;

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
