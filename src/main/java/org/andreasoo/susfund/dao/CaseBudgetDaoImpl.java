package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.entity.CaseBudget;

@ApplicationScoped
public class CaseBudgetDaoImpl implements CaseBudgetDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseBudget getCaseBudgetByCaseId(int caseId) {
        return entityManager.createQuery(
                "select ca from Cases c join c.caseBudget ca where c.id=" + caseId, CaseBudget.class).getSingleResult();
    }
}
