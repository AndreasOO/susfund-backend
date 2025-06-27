package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.Financing;

import java.util.List;

public interface CaseBudgetDao {
    CaseBudget getCaseBudgetByCaseId(int caseId);
    CaseBudget updateCaseBudget(CaseBudget caseBudget);
    boolean updateFinancingByCaseId(int caseBudgetId, List<Financing> financing);
}
