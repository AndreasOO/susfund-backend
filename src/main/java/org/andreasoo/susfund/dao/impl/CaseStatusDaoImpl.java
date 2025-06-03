package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CaseStatusDao;
import org.andreasoo.susfund.entity.CaseStatus;

@ApplicationScoped
public class CaseStatusDaoImpl implements CaseStatusDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseStatus getCaseStatusByCaseId(int caseId) {
        return entityManager.createQuery(
                "select cs from Cases c join c.caseStatus cs where c.id=" + caseId, CaseStatus.class).getSingleResult();
    }
}
