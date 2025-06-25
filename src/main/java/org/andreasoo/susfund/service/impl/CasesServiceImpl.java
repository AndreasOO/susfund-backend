package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.dao.*;
import org.andreasoo.susfund.entity.*;
import org.andreasoo.susfund.service.CasesService;
import org.andreasoo.susfund.util.*;

import java.util.List;

@ApplicationScoped
public class CasesServiceImpl implements CasesService {

    @Inject
    private CasesDao casesDao;

    @Inject
    private CaseAssessmentDao caseAssessmentDao;

    @Inject
    private CaseApplicationDao caseApplicationDao;

    @Inject
    private CaseBudgetDao caseBudgetDao;

    @Inject
    private CaseDecisionDao caseDecisionDao;

    @Inject
    private CaseStatusDao caseStatusDao;

    @Inject
    private CaseDecisionTypeDao caseDecisionTypeDao;

    @Inject
    private OrganizationDao organizationDao;

    @Inject
    private HistoryEventDao historyEventDao;

    @Inject
    private CaseManagerDao caseManagerDao;

    @Inject
    private CaseDecisionResultDao caseDecisionResultDao;


    @Override
    public Cases getCaseById(int id) {
        return casesDao.getCaseById(id);
    }

    @Override
    public List<Cases> getAllCases() {
        return casesDao.getAllCases();
    }

    @Override
    public AssessmentUtil getAssessmentUtilByCaseId(int id) {
        return caseAssessmentDao.getAssessmentUtilByCaseId(id);
    }

    @Transactional
    @Override
    public boolean updateAssessmentItem(int caseId, AssessmentUpdateRequest request) {
        return caseAssessmentDao.updateAssessmentResultById(caseId, request);
    }

    @Override
    public ApplicationUtil getApplicationUtilByCaseId(int id) {
        return caseApplicationDao.getApplicationUtilByCaseId(id);
    }

    @Transactional
    @Override
    public boolean updateApplicationQuestion(int caseId, ApplicationUpdateRequest request) {
        return caseApplicationDao.updateQuestionResultById(caseId, request);
    }

    @Override
    public CaseBudget getCaseBudgetByCaseId(int id) {
        return caseBudgetDao.getCaseBudgetByCaseId(id);
    }

    @Override
    public CaseDecision getCaseDecisionByCaseId(int id) {
        return caseDecisionDao.getCaseDecisionByCaseId(id);
    }

    @Override
    public CaseStatus getCaseStatusByCaseId(int id) {
        return caseStatusDao.getCaseStatusByCaseId(id);
    }

    @Override
    public CaseDecisionType getCaseDecisionTypeByCaseId(int id) {
        return caseDecisionTypeDao.getCaseDecisionTypeByCaseId(id);
    }

    @Override
    public Organization getOrganizationByCaseId(int id) {
        return organizationDao.getOrganizationByCaseId(id);
    }

    @Override
    public List<HistoryEvent> getHistoryEventsByCaseId(int id) {
        return historyEventDao.getHistoryEventsByCaseId(id);
    }

    @Override
    public CaseManager getCaseManagerByCaseId(int id) {
        return caseManagerDao.getCaseManagerByCaseId(id);
    }

    @Override
    public CaseManager getCaseControllerByCaseId(int id) {
        return casesDao.getCaseControllerByCaseId(id);
    }

    @Override
    public CaseManager getHandledByByCaseId(int id) {
        return casesDao.getHandledByByCaseId(id);
    }

    @Override
    public List<CaseManager> getCaseManagers() {
        return caseManagerDao.getAllCaseManagers();
    }

    @Override
    public List<CaseDecision> getCaseDecisions() {
        return caseDecisionDao.getAllCaseDecisions();
    }

    @Override
    public List<CaseDecisionResult> getCaseDecisionResults() {
        return caseDecisionResultDao.getAllCaseDecisionResults();
    }

    @Override
    public List<Cases> getCasesRelatedToCaseOrganization(int id) {
        return casesDao.getCasesRelatedToOrganization(id);
    }

    // NYTT
    @Transactional
    @Override
    public boolean updateCaseAssignment(int caseId, int caseManagerId, int caseControllerId, int handledById){
        return casesDao.updateCaseAssignment(caseId, caseManagerId, caseControllerId, handledById);
    }

    @Transactional
    @Override
    public boolean updateCaseDecision(int caseId, CaseDecisionUpdateRequest request){
        return casesDao.updateCaseDecision(caseId, request);
    }

}
