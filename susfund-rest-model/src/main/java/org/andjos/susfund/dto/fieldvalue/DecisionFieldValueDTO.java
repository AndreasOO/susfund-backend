package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.CaseManagerDTO;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.field.value.decision.DecisionFieldValue;
import org.andjos.susfund.entity.field.value.decision.DecisionResultType;

public class DecisionFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private DecisionResultType decisionResultType;

    private String motivation;

    private CaseManagerDTO decisionController;

    public DecisionFieldValueDTO() {
        super();
    }

    protected DecisionFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "decisionFieldValue");
    }

    public DecisionFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, DecisionResultType decisionResultType, String motivation) {
        super(id, owningCaseId, owningFieldDefinition, "decisionFieldValue");
        this.decisionResultType = decisionResultType;
        this.motivation = motivation;
    }

    public DecisionFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, DecisionResultType decisionResultType, String motivation, CaseManagerDTO decisionController) {
        super(id, owningCaseId, owningFieldDefinition, "decisionFieldValue");
        this.decisionResultType = decisionResultType;
        this.motivation = motivation;
        this.decisionController = decisionController;
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

    public CaseManagerDTO getDecisionController() {
        return decisionController;
    }

    public void setDecisionController(CaseManagerDTO decisionController) {
        this.decisionController = decisionController;
    }
}
