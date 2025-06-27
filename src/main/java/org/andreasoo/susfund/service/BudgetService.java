package org.andreasoo.susfund.service;

import jakarta.transaction.Transactional;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.Financing;
import org.andreasoo.susfund.util.Result;

import java.util.List;

public interface BudgetService {
    @Transactional
    Result<CaseBudget> createBudget(CaseBudget caseBudget);

    @Transactional
    Result<CaseBudget> updateBudget(int id, CaseBudget caseBudget);

    @Transactional
    Result<CaseBudget> updateFinancing(int caseId, CaseBudget caseBudget);

    @Transactional
    boolean updateFinancingListByCaseId(int id, List<Financing> financingList);
}
