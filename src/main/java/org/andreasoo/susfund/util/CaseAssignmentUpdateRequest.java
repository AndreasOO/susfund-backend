package org.andreasoo.susfund.util;

public class CaseAssignmentUpdateRequest {
    private int caseManagerId;
    private int caseControllerId;
    private int handledById;

    public int getCaseManagerId() {
        return caseManagerId;
    }

    public void setCaseManagerId(int caseManagerId) {
        this.caseManagerId = caseManagerId;
    }

    public int getCaseControllerId() {
        return caseControllerId;
    }

    public void setCaseControllerId(int caseControllerId) {
        this.caseControllerId = caseControllerId;
    }

    public int getHandledById() {
        return handledById;
    }

    public void setHandledById(int handledById) {
        this.handledById = handledById;
    }
}
