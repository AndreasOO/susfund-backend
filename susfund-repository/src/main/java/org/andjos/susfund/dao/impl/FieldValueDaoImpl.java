package org.andjos.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

@ApplicationScoped
public class FieldValueDaoImpl implements FieldValueDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AbstractFieldValue<? extends FieldDefinition> findById(Long id) {
        return entityManager.find(AbstractFieldValue.class, id);
    }
    @Override
    public AbstractFieldValue<? extends FieldDefinition> save(AbstractFieldValue<? extends FieldDefinition>  fieldValue) {
        return entityManager.merge(fieldValue);
    }
}
