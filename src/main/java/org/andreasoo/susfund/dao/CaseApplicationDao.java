package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.util.ApplicationUtil;
import org.andreasoo.susfund.util.QuestionUpdateRequest;

public interface CaseApplicationDao {
    ApplicationUtil getApplicationUtilByCaseId(int caseId);
    void updateQuestionResultById(int caseId, QuestionUpdateRequest questionUpdateRequest);
}
