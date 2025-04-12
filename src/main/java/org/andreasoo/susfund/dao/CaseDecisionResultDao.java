package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseDecision;
import org.andreasoo.susfund.entity.CaseDecisionResult;

import java.util.List;

public interface CaseDecisionResultDao {
    List<CaseDecisionResult> getAllCaseDecisionResults();
}
