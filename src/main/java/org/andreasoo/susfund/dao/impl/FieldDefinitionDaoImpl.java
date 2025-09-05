package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.FieldDefinitionDao;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;

import java.util.List;

@ApplicationScoped
public class FieldDefinitionDaoImpl implements FieldDefinitionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FieldDefinition getFieldDefinitionById(Long id) {
        return entityManager.find(FieldDefinition.class, id);
    }

    @Override
    public List<FieldDefinition> getAllFieldDefinitions() {
        return entityManager.createQuery("select fdn from FieldDefinition fdn", FieldDefinition.class).getResultList();
    }

    @Override
    public FieldDefinition saveFieldDefinition(FieldDefinition fieldDefinition) {
        return entityManager.merge(fieldDefinition);
    }


}
