package org.andreasoo.susfund.dao.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CasesDao;
import org.andreasoo.susfund.entity.CaseManager;
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

    @Override
    public List<Cases> getCasesRelatedToOrganization(int organizationId) {
        return entityManager.createQuery("select c from Cases c join c.organization o where o.id="+organizationId,Cases.class).getResultList();
    }

    // NYTT
    @Override
    public boolean updateCaseManager(int caseId, int caseManagerId){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            CaseManager chosenCaseManager = entityManager.find(CaseManager.class, caseManagerId);
            currentCase.setCaseManager(chosenCaseManager);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
