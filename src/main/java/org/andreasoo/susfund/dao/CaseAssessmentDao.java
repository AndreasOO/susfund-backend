package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.AssessmentResult;
import org.andreasoo.susfund.util.AssessmentUpdateRequest;
import org.andreasoo.susfund.util.AssessmentUtil;

public interface CaseAssessmentDao {
    AssessmentUtil getAssessmentUtilByCaseId(int caseId);
    void updateAssessmentResultById(int caseId, AssessmentUpdateRequest request);
}
