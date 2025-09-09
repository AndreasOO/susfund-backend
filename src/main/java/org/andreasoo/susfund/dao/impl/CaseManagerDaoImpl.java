package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CaseManagerDao;
import org.andreasoo.susfund.entity.old.CaseManager;

import java.util.List;

@ApplicationScoped
public class CaseManagerDaoImpl implements CaseManagerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseManager getCaseManagerByCaseId(int caseId) {
        return entityManager.createQuery(
                "select cm from CaseEntity c join c.caseManager cm where c.id=" + caseId, CaseManager.class).getSingleResult();
    }

    @Override
    public List<CaseManager> getAllCaseManagers() {
        return entityManager.createQuery("select cm from CaseManager cm", CaseManager.class).getResultList();
    }

    @Override
    public CaseManager getCaseManagerById(int id) {
        return entityManager.find(CaseManager.class, id);
    }
}
