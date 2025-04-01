package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.entity.CaseBudget;
import org.andreasoo.susfund.entity.CaseDecision;

@ApplicationScoped
public class CaseDecisionDaoImpl implements CaseDecisionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseDecision getCaseDecisionByCaseId(int caseId) {
        return entityManager.createQuery(
                "select ca from Cases c join c.caseDecision ca where c.id=" + caseId, CaseDecision.class).getSingleResult();
    }
}
