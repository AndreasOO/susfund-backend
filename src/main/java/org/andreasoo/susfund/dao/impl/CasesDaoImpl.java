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
    public boolean updateCaseAssignment(int caseId, int caseManagerId, int caseControllerId, int handledById){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);

            CaseManager chosenCaseManager = entityManager.find(CaseManager.class, caseManagerId);
            CaseManager chosenCaseController = entityManager.find(CaseManager.class, caseControllerId);
            CaseManager chosenHandledBy = entityManager.find(CaseManager.class, handledById);

            if (chosenCaseManager.equals(chosenCaseController) && chosenCaseManager.getId() != 1 && chosenCaseController.getId() != 1 ||
                    chosenCaseManager.equals(chosenHandledBy) && chosenCaseManager.getId() != 1 && chosenHandledBy.getId() != 1 ||
                    chosenCaseController.equals(chosenHandledBy) && chosenCaseController.getId() != 1 && chosenHandledBy.getId() != 1) {
                return false;
            }

            currentCase.setCaseManager(chosenCaseManager);
            currentCase.setCaseController(chosenCaseController);
            currentCase.setHandledBy(chosenHandledBy);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public CaseManager getCaseControllerByCaseId(int caseId){
        return entityManager.find(Cases.class, caseId).getCaseController();
    }

    @Override
    public CaseManager getHandledByByCaseId(int caseId){
        return entityManager.find(Cases.class, caseId).getHandledBy();
    }
}
