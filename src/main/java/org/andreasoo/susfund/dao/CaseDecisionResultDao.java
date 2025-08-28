package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.CaseDecisionResult;

import java.util.List;

public interface CaseDecisionResultDao {
    List<CaseDecisionResult> getAllCaseDecisionResults();
    CaseDecisionResult getCaseDecisionResultById(int id);
}
