package org.andreasoo.susfund.util;

import org.andreasoo.susfund.entity.CaseDecisionType;

public class CaseDecisionUpdateRequest {
    int caseDecisionResultId;
    String justification;
    int caseControllerId;

    public int getCaseDecisionResultId() {
        return caseDecisionResultId;
    }

    public void setCaseDecisionResultId(int caseDecisionResultId) {
        this.caseDecisionResultId = caseDecisionResultId;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public int getCaseControllerId() {
        return caseControllerId;
    }

    public void setCaseControllerId(int caseControllerId) {
        this.caseControllerId = caseControllerId;
    }
}
