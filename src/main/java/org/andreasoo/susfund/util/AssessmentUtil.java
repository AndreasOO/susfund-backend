package org.andreasoo.susfund.util;

import org.andreasoo.susfund.entity.old.AssessmentResult;


import java.util.List;

public class AssessmentUtil {
    private int caseAssessmentId;
    private List<List<AssessmentResult>> assessmentResults;

    public AssessmentUtil() {
    }

    public Integer getCaseAssessmentId() {
        return caseAssessmentId;
    }

    public void setCaseAssessmentId(int caseAssessmentId) {
        this.caseAssessmentId = caseAssessmentId;
    }

    public List<List<AssessmentResult>> getAssessmentResults() {
        return assessmentResults;
    }

    public void setAssessmentResults(List<List<AssessmentResult>> assessmentResults) {
        this.assessmentResults = assessmentResults;
    }
}
