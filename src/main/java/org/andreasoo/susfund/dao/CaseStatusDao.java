package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.CaseStatus;

public interface CaseStatusDao {
    CaseStatus getCaseStatusByCaseId(int caseId);
}
