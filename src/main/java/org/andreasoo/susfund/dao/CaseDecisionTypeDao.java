package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.CaseDecisionType;

public interface CaseDecisionTypeDao {
    CaseDecisionType getCaseDecisionTypeByCaseId(int caseId);
}
