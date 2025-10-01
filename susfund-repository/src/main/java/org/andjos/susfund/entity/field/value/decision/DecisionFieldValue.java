package org.andjos.susfund.entity.field.value.decision;

import jakarta.persistence.*;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.field.definition.selectable.SelectableFieldDefinition;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="DECISION")
public class DecisionFieldValue extends AbstractFieldValue<SelectableFieldDefinition> {

    @Column(name="decision_result_type")
    @Enumerated(EnumType.STRING)
    private DecisionResultType decisionResultType;

    @Column(name="decision_motivation")
    private String motivation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="decision_controller")
    private CaseManager decisionController;

    public DecisionFieldValue() {
        super();
    }

    public DecisionFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

    public DecisionFieldValue(CaseEntity owningCase, DecisionResultType decisionResultType, String motivation) {
        super(owningCase);
        this.decisionResultType = decisionResultType;
        this.motivation = motivation;
    }


    public DecisionFieldValue(CaseEntity owningCase, DecisionResultType decisionResultType, String motivation, CaseManager decisionController) {
        super(owningCase);
        this.decisionResultType = decisionResultType;
        this.motivation = motivation;
        this.decisionController = decisionController;
    }

    @Override
    public String getValueAsString() {
        return "";
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

    public CaseManager getDecisionController() {
        return decisionController;
    }

    public void setDecisionController(CaseManager decisionController) {
        this.decisionController = decisionController;
    }
}
