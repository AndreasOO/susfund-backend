package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.dao.CaseBudgetDao;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.entity.Financing;

import java.util.List;

@ApplicationScoped
public class CaseBudgetDaoImpl implements CaseBudgetDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseBudget getCaseBudgetByCaseId(int caseId) {
        return entityManager.createQuery(
                "select cb from Cases c join c.caseBudget cb where c.id=" + caseId, CaseBudget.class).getSingleResult();
    }

    @Override
    public CaseBudget updateCaseBudget(CaseBudget caseBudget) {
        return entityManager.merge(caseBudget);
    }


    @Transactional
    @Override
    public boolean updateFinancingByCaseId(int caseId, List<Financing> financing){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            CaseBudget currentCaseBudget = currentCase.getCaseBudget();

            currentCaseBudget.getFinancing().clear();

            for(Financing f: financing){
                currentCaseBudget.getFinancing().add(f);
            }

            currentCaseBudget.setFinancing(financing);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
