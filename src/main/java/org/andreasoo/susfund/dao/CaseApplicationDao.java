package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.util.ApplicationUtil;
import org.andreasoo.susfund.util.ApplicationUpdateRequest;

public interface CaseApplicationDao {
    ApplicationUtil getApplicationUtilByCaseId(int caseId);
    boolean updateQuestionResultById(int caseId, ApplicationUpdateRequest applicationUpdateRequest);
}
