package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CaseDecisionResultDao;
import org.andreasoo.susfund.entity.old.CaseDecisionResult;

import java.util.List;

@ApplicationScoped
public class CaseDecisionResultDaoImpl implements CaseDecisionResultDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CaseDecisionResult> getAllCaseDecisionResults() {
        return entityManager.createQuery("select cdr from CaseDecisionResult cdr",CaseDecisionResult.class).getResultList();
    }

    public CaseDecisionResult getCaseDecisionResultById(int id) {
        return entityManager.find(CaseDecisionResult.class, id);
    }
}
