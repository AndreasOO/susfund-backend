package org.andreasoo.susfund.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.entity.*;
import org.andreasoo.susfund.util.ApplicationUpdateRequest;
import org.andreasoo.susfund.util.ApplicationUtil;
import org.andreasoo.susfund.util.AssessmentUpdateRequest;
import org.andreasoo.susfund.util.AssessmentUtil;

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

    List<CaseManager> getCaseManagers();

    List<CaseDecision> getCaseDecisions();

    List<CaseDecisionResult> getCaseDecisionResults();

    List<Cases> getCasesRelatedToCaseOrganization(int id);
}
