package org.andreasoo.susfund.service;

import jakarta.transaction.Transactional;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.util.Result;

public interface BudgetService {
    @Transactional
    Result<CaseBudget> createBudget(CaseBudget caseBudget);

    @Transactional
    Result<CaseBudget> updateBudget(int id, CaseBudget caseBudget);

    @Transactional
    Result<CaseBudget> updateFinancing(int id, CaseBudget caseBudget);
}
