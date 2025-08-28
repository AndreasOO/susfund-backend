package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.CaseBudget;

public interface CaseBudgetDao {
    CaseBudget getCaseBudgetByCaseId(int caseId);
}
