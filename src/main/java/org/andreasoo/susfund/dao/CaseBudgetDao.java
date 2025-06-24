package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseBudget;

public interface CaseBudgetDao {
    CaseBudget getCaseBudgetByCaseId(int caseId);
    CaseBudget updateCaseBudget(CaseBudget caseBudget);
}
