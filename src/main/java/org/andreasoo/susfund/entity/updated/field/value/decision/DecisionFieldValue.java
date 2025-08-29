package org.andreasoo.susfund.entity.updated.field.value.decision;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

public class DecisionFieldValue extends AbstractFieldValue<FieldDefinition> {

    public DecisionFieldValue() {
        super();
    }

    @Column(name="decision_result_type")
    @Enumerated(EnumType.STRING)
    private DecisionResultType decisionResultType;

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
}
