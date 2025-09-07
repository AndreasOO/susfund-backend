package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.CaseDecisionResult;
import org.andreasoo.susfund.entity.old.CaseManager;
import org.andreasoo.susfund.entity.old.Cases;
import org.andreasoo.susfund.entity.updated.CaseEntity;

import java.util.List;


public interface CasesDao {

    List<CaseEntity> getAllCaseEntities();

    List<Cases> getAllCases();

    Cases getCaseById(int id);

    List<Cases> getCasesRelatedToOrganization(int organizationId);

    CaseManager getCaseControllerByCaseId(int id);

    CaseManager getHandledByByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int caseId);

    boolean updateCaseDecisionResultByCaseId(int caseId, CaseDecisionResult caseDecisionResult);

    boolean updateJustificationByCaseId(int caseId, String justification);

    boolean updateCaseControllerByCaseId(int caseId, CaseManager caseController);

    boolean updateCaseManagerByCaseId(int caseId, CaseManager caseManager);

    boolean updateHandledByByCaseId(int caseId, CaseManager handledBy);
}
