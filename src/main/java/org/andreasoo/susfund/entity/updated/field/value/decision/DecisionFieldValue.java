package org.andreasoo.susfund.entity.updated.field.value.decision;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.selectable.SelectableFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="DECISION")
public class DecisionFieldValue extends AbstractFieldValue<SelectableFieldDefinition> {

    @Column(name="decision_result_type")
    @Enumerated(EnumType.STRING)
    private DecisionResultType decisionResultType;

    @Column(name="decision_motivation")
    private String motivation;

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
}
