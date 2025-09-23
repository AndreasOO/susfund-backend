package org.andjos.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andjos.susfund.dao.CaseEntityDao;
import org.andjos.susfund.entity.caseentity.CaseEntity;

import java.util.List;

@ApplicationScoped
public class CaseEntityDaoImpl implements CaseEntityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CaseEntity getById(Long id) {
        CaseEntity caseEntity = entityManager.find(CaseEntity.class, id);
        caseEntity.getFieldValues();
        return caseEntity;
    }

    @Override
    public CaseEntity save(CaseEntity caseEntity) {
        return entityManager.merge(caseEntity);
    }

    @Override
    public List<CaseEntity> getAll() {
        return entityManager.createQuery("select c from CaseEntity c", CaseEntity.class).getResultList();
    }
}
