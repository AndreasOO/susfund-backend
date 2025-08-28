package org.andreasoo.susfund.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.FieldDefinitionDao;
import org.andreasoo.susfund.entity.updated.FieldDefinition;

import java.util.List;

public class FieldDefinitionDaoImpl implements FieldDefinitionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FieldDefinition getFieldDefinitionById(Long id) {
        return entityManager.find(FieldDefinition.class, id);
    }

    @Override
    public List<FieldDefinition> getAllFieldDefinitionByCaseId(Long caseId) {
        return entityManager.createQuery("select fd from FieldDefinition fd join AbstractFieldValue fv where :caseId = fv.owningCase.id").getResultList();
    }

    @Override
    public FieldDefinition saveFieldDefinition(FieldDefinition fieldDefinition) {
        return entityManager.merge(fieldDefinition);
    }


}
