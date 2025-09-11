package dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import dao.SelectableValueDao;
import entity.field.definition.selectable.SelectableValue;

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
