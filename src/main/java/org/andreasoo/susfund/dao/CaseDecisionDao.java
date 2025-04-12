package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.CaseDecision;

import java.util.List;

public interface CaseDecisionDao {
    CaseDecision getCaseDecisionByCaseId(int caseId);
    List<CaseDecision> getAllCaseDecisions();
}
