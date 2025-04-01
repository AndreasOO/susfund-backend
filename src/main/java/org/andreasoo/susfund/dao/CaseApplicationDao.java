package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.util.ApplicationUtil;
import org.andreasoo.susfund.util.AssessmentUtil;

public interface CaseApplicationDao {
    ApplicationUtil getApplicationUtilByCaseId(int caseId);
}
