package org.andreasoo.susfund.dao;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.entity.Cases;

import java.util.List;


@ApplicationScoped
public class CasesDaoImpl implements CasesDao {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<Cases> getAllCases() {
        return entityManager.createNamedQuery("Cases.findAll", Cases.class).getResultList();
    }

    @Override
    public Cases getCaseById(int id) {
        return entityManager.find(Cases.class, id);
    }
}
