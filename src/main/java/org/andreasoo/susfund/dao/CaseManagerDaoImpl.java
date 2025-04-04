package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.entity.CaseManager;
import org.andreasoo.susfund.entity.CaseStatus;

import java.util.List;

@ApplicationScoped
public class CaseManagerDaoImpl implements CaseManagerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseManager getCaseManagerByCaseId(int caseId) {
        return entityManager.createQuery(
                "select cm from Cases c join c.caseManager cm where c.id=" + caseId, CaseManager.class).getSingleResult();
    }

    @Override
    public List<CaseManager> getAllCaseManagers() {
        return entityManager.createQuery("select cm from CaseManager cm", CaseManager.class).getResultList();
    }
}
