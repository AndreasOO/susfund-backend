package org.andreasoo.susfund.dao.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.CasesDao;
import org.andreasoo.susfund.entity.old.CaseDecisionResult;
import org.andreasoo.susfund.entity.old.CaseManager;
import org.andreasoo.susfund.entity.old.Cases;
import org.andreasoo.susfund.entity.updated.CaseEntity;

import java.util.List;


@ApplicationScoped
public class CasesDaoImpl implements CasesDao {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<CaseEntity> getAllCaseEntities() {
        return entityManager.createNamedQuery("CaseEntity.findAll", CaseEntity.class).getResultList();
    }

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

    @Override
    public CaseManager getCaseControllerByCaseId(int caseId){
        return entityManager.find(Cases.class, caseId).getCaseController();
    }

    @Override
    public CaseManager getHandledByByCaseId(int caseId){
        return entityManager.find(Cases.class, caseId).getHandledBy();
    }

    @Override
    public CaseManager getCaseManagerByCaseId(int caseId){
        return entityManager.find(Cases.class, caseId).getCaseManager();
    }

    @Override
    public boolean updateCaseControllerByCaseId(int caseId, CaseManager caseController){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            currentCase.setCaseController(caseController);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCaseManagerByCaseId(int caseId, CaseManager caseManager){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            currentCase.setCaseManager(caseManager);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateHandledByByCaseId(int caseId, CaseManager handledBy){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            currentCase.setHandledBy(handledBy);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCaseDecisionResultByCaseId(int caseId, CaseDecisionResult caseDecisionResult){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            currentCase.getCaseDecision().setCaseDecisionResult(caseDecisionResult);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJustificationByCaseId(int caseId, String justification){
        try{
            Cases currentCase = entityManager.find(Cases.class, caseId);
            currentCase.getCaseDecision().setJustification(justification);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
