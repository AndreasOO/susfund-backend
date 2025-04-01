package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.util.AssessmentUtil;

public interface CaseAssessmentDao {
    AssessmentUtil getAssessmentUtilByCaseId(int caseId);
}
