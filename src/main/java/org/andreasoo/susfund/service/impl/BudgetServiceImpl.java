package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.service.BudgetService;
import org.andreasoo.susfund.util.BudgetServiceUtil;
import org.andreasoo.susfund.util.Result;

@ApplicationScoped
public class BudgetServiceImpl implements BudgetService {

    BudgetServiceUtil budgetServiceUtil = new BudgetServiceUtil();

    @Override
    public Result<CaseBudget> createBudget(CaseBudget caseBudget) {

        return budgetServiceUtil.calculateNewBudget(caseBudget);
    }

    @Override
    public Result<CaseBudget> updateBudget(CaseBudget caseBudget) {

        return budgetServiceUtil.calculateExistingBudget(caseBudget);
    }
}
