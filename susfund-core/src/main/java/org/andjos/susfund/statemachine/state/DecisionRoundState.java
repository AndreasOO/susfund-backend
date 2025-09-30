package org.andjos.susfund.statemachine.state;

import org.andjos.susfund.entity.caseentity.CaseDecisionType;
import org.andjos.susfund.entity.caseentity.CaseStatus;

import java.util.Objects;

public class DecisionRoundState {

    private final CaseDecisionType caseDecisionType;
    private final CaseStatus caseStatus;

    public DecisionRoundState(CaseDecisionType caseDecisionType, CaseStatus caseStatus) {
        this.caseDecisionType = caseDecisionType;
        this.caseStatus = caseStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DecisionRoundState that)) return false;
        return caseDecisionType == that.caseDecisionType && caseStatus == that.caseStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseDecisionType, caseStatus);
    }
}
