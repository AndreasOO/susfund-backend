package org.andreasoo.susfund.service;

import jakarta.transaction.Transactional;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.util.*;

import java.util.List;

public interface CasesService {

    Cases getCaseById(int id);

    List<Cases> getAllCases();

    AssessmentUtil getAssessmentUtilByCaseId(int id);

    @Transactional
    boolean updateAssessmentItem(int caseId, AssessmentUpdateRequest request);

    ApplicationUtil getApplicationUtilByCaseId(int id);

    @Transactional
    boolean updateApplicationQuestion(int caseId, ApplicationUpdateRequest request);

    CaseBudget getCaseBudgetByCaseId(int id);

    CaseDecision getCaseDecisionByCaseId(int id);

    CaseStatus getCaseStatusByCaseId(int id);

    CaseDecisionType getCaseDecisionTypeByCaseId(int id);

    Organization getOrganizationByCaseId(int id);

    List<HistoryEvent> getHistoryEventsByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int id);

    CaseManager getCaseControllerByCaseId(int id);

    CaseManager getHandledByByCaseId(int id);

    List<CaseManager> getCaseManagers();

    List<CaseDecision> getCaseDecisions();

    List<CaseDecisionResult> getCaseDecisionResults();

    List<Cases> getCasesRelatedToCaseOrganization(int id);

    // NYTT
    @Transactional
    boolean updateCaseAssignment(int caseId, int caseManagerId, int caseControllerId, int handledById);

    @Transactional
    boolean updateCaseDecision(int caseId, CaseDecisionUpdateRequest request);
}
