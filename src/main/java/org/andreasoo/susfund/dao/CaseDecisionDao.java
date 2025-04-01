package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.CaseDecision;

public interface CaseDecisionDao {
    CaseDecision getCaseDecisionByCaseId(int caseId);
}
