package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.SelectableValueDao;
import org.andreasoo.susfund.entity.field.definition.selectable.SelectableValue;

import java.util.List;

@ApplicationScoped
public class SelectableValueDaoImpl implements SelectableValueDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<SelectableValue> saveSelectableValues(List<SelectableValue> selectableValues) {
        return em.merge(selectableValues);
    }

    @Override
    public List<SelectableValue> getAllSelectableValues() {
        return em.createQuery("select sv from SelectableValue sv", SelectableValue.class).getResultList();
    }
}
