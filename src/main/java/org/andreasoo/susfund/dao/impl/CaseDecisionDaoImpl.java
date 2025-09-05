package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CaseDecisionDao;
import org.andreasoo.susfund.entity.old.CaseDecision;

import java.util.List;

@ApplicationScoped
public class CaseDecisionDaoImpl implements CaseDecisionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseDecision getCaseDecisionByCaseId(int caseId) {
        return entityManager.createQuery(
                "select cd from Cases c join c.caseDecision cd where c.id=" + caseId, CaseDecision.class).getSingleResult();
    }

    @Override
    public List<CaseDecision> getAllCaseDecisions() {
        return entityManager.createQuery("select cd from CaseDecision cd",CaseDecision.class).getResultList();
    }
}
