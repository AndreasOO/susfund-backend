package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dao.CaseBudgetDao;
import org.andreasoo.susfund.dao.CasesDao;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.service.BudgetService;
import org.andreasoo.susfund.util.BudgetServiceUtil;
import org.andreasoo.susfund.util.Result;

@ApplicationScoped
public class BudgetServiceImpl implements BudgetService {

    @Inject
    CaseBudgetDao caseBudgetDao;

    @Inject
    CasesDao casesDao;

    BudgetServiceUtil budgetServiceUtil = new BudgetServiceUtil();

    @Override
    public Result<CaseBudget> createBudget(CaseBudget caseBudget) {
        return budgetServiceUtil.createNewBudget(caseBudget);

    }

    @Override
    public Result<CaseBudget> updateBudget(int id, CaseBudget caseBudget) {
        Result<CaseBudget> calculatedCaseBudget = budgetServiceUtil.updateExistingBudget(caseBudget);
        if (calculatedCaseBudget.success()) {
            Cases caseToUpdate = casesDao.getCaseById(id);
            caseToUpdate.setCaseBudget(calculatedCaseBudget.resultObj());
            Cases updatedCase = casesDao.updateCase(caseToUpdate);
            updatedCase.getCaseBudget().getBudgetPosts().forEach(post -> System.out.println(post.getEstimatedCost() + " " + post.getBudgetPostType().getName()));
        }
        return new Result<>(calculatedCaseBudget.resultObj(), calculatedCaseBudget.error(),  calculatedCaseBudget.success());
    }

    @Override
    public Result<CaseBudget> updateFinancing(int id) {
        CaseBudget caseBudget = caseBudgetDao.getCaseBudgetByCaseId(id);
        Result<CaseBudget> validatedCaseBudget = budgetServiceUtil.updateExistingFinancing(caseBudget);
        if (validatedCaseBudget.success()) {
            Cases caseToUpdate = casesDao.getCaseById(id);
            caseToUpdate.setCaseBudget(validatedCaseBudget.resultObj());
            Cases updatedCase = casesDao.updateCase(caseToUpdate);
            updatedCase.getCaseBudget().getFinancing().forEach(financing -> System.out.println(financing.getEstimatedFinancingInMoney() + " " + financing.getEstimatedFinancingInPercentage()));
        }
        return new Result<>(validatedCaseBudget.resultObj(), validatedCaseBudget.error(), validatedCaseBudget.success());
    }
}
