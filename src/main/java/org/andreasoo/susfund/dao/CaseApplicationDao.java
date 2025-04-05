package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.util.ApplicationUtil;

public interface CaseApplicationDao {
    ApplicationUtil getApplicationUtilByCaseId(int caseId);
    void updateQuestionResultById(int caseId, int questionResultId, String updatedAnswer);
}
