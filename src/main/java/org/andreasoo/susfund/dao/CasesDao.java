package org.andreasoo.susfund.dao;

import jakarta.inject.Inject;
import org.andreasoo.susfund.entity.CaseManager;
import org.andreasoo.susfund.entity.Cases;

import java.util.List;


public interface CasesDao {
    List<Cases> getAllCases();
    Cases getCaseById(int id);
    List<Cases> getCasesRelatedToOrganization(int organizationId);
    // NYTT
    boolean updateCaseAssignment(int caseId,int caseManagerId, int caseControllerId, int handledById);

    CaseManager getCaseControllerByCaseId(int id);
    CaseManager getHandledByByCaseId(int id);
}
