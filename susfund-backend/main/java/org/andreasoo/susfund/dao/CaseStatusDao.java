package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseDecision;
import org.andreasoo.susfund.entity.CaseStatus;

public interface CaseStatusDao {
    CaseStatus getCaseStatusByCaseId(int caseId);
}
