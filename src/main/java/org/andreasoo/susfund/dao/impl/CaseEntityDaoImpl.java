package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CaseEntityDao;
import org.andreasoo.susfund.entity.updated.CaseEntity;

@ApplicationScoped
public class CaseEntityDaoImpl implements CaseEntityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseEntity getById(Long id) {
        CaseEntity caze = entityManager.find(CaseEntity.class, id);
        caze.getFieldValues();
        return caze;
    }

    @Override
    public CaseEntity save(CaseEntity caseEntity) {
        return entityManager.merge(caseEntity);
    }
}
