package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.dao.CaseBudgetDao;
import org.andreasoo.susfund.dao.CasesDao;
import org.andreasoo.susfund.dao.FinancingDao;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.entity.Financing;
import org.andreasoo.susfund.service.BudgetService;
import org.andreasoo.susfund.util.BudgetServiceUtil;
import org.andreasoo.susfund.util.Result;

import java.util.List;

@ApplicationScoped
public class BudgetServiceImpl implements BudgetService {

    @Inject
    CaseBudgetDao caseBudgetDao;

    @Inject
    CasesDao casesDao;

    @Inject
    FinancingDao financingDao;

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
    public Result<CaseBudget> updateFinancing(int caseId, CaseBudget caseBudget) {
        Result<CaseBudget> validatedCaseBudget = budgetServiceUtil.updateExistingFinancing(caseBudget);
        if (validatedCaseBudget.success()) {
            Cases caseToUpdate = casesDao.getCaseById(caseId);
            caseToUpdate.setCaseBudget(validatedCaseBudget.resultObj());
            Cases updatedCase = casesDao.updateCase(caseToUpdate);
            updatedCase.getCaseBudget().getFinancing().forEach(financing -> System.out.println(financing.getEstimatedFinancingInMoney() + " " + financing.getEstimatedFinancingInPercentage()));
        }
        return new Result<>(validatedCaseBudget.resultObj(), validatedCaseBudget.error(), validatedCaseBudget.success());
    }

    @Override
    public boolean updateFinancingListByCaseId(int id, List<Financing> updatedFinancing){
        try{
            CaseBudget caseBudget = caseBudgetDao.getCaseBudgetByCaseId(id);
            List<Financing> existingFinancing = caseBudget.getFinancing();

            updatedFinancing.forEach(update -> { existingFinancing
                    .stream()
                    .filter(existing -> existing.getId() == update.getId())
                    .findFirst()
                    .ifPresent(existing -> financingDao.updateFinancingById(existing.getId(), update.getEstimatedFinancingInPercentage(), update.getEstimatedFinancingInMoney()));
            });

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
