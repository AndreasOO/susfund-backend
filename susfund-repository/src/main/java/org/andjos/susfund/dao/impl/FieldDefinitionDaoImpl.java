package org.andjos.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andjos.susfund.dao.FieldDefinitionDao;
import org.andjos.susfund.entity.field.definition.FieldDefinition;

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
