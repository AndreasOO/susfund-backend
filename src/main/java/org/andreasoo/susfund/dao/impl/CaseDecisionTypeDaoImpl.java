package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CaseDecisionTypeDao;
import org.andreasoo.susfund.entity.CaseDecisionType;

@ApplicationScoped
public class CaseDecisionTypeDaoImpl implements CaseDecisionTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseDecisionType getCaseDecisionTypeByCaseId(int caseId) {
        return entityManager.createQuery(
                "select cdt from Cases c join c.caseDecisionType cdt where c.id=" + caseId, CaseDecisionType.class).getSingleResult();
    }
}
