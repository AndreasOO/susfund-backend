package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseDecision;
import org.andreasoo.susfund.entity.CaseDecisionType;

public interface CaseDecisionTypeDao {
    CaseDecisionType getCaseDecisionTypeByCaseId(int caseId);
}
