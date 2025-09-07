package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.dao.*;
import org.andreasoo.susfund.dto.CaseDTO;
import org.andreasoo.susfund.dto.SimpleCaseDTO;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.CaseDecisionType2;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.CaseStatus2;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.budget.BudgetFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.budget.BudgetRow;
import org.andreasoo.susfund.entity.updated.field.value.budget.CostType;
import org.andreasoo.susfund.entity.updated.field.value.budget.FinancingRow;
import org.andreasoo.susfund.entity.updated.field.value.budget.FinancingType;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionResultType;
import org.andreasoo.susfund.entity.updated.field.value.history.HistoryEvent2;
import org.andreasoo.susfund.entity.updated.field.value.history.HistoryEventType;
import org.andreasoo.susfund.entity.updated.field.value.history.HistoryLogFieldValue;
import org.andreasoo.susfund.service.CasesService;
import org.andreasoo.susfund.util.*;

import java.time.LocalDate;
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

    @Inject
    private FieldDefinitionDao fieldDefinitionDao;

    @Inject
    private CaseEntityDao caseEntityDao;

    @Inject
    private SupportTypeNodeDao supportTypeNodeDao;



    @Override
    public List<CaseEntity> getAllCaseEntities() {
        return casesDao.getAllCaseEntities();
    }

//    @Override
//    public List<SimpleCaseDTO> getAllCasesSimple() {
//        List<CaseEntity> cases = casesDao.getAllCaseEntities();
//        return cases.stream().map(caseEntity -> (SimpleCaseDTO) generalMappingService.mapToDTO(caseEntity)).toList();
//    }

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

        CaseManager chosenCaseManager = caseManagerDao.getCaseManagerById(caseManagerId);
        CaseManager chosenCaseController = caseManagerDao.getCaseManagerById(caseControllerId);
        CaseManager chosenHandledBy = caseManagerDao.getCaseManagerById(handledById);

        if (chosenCaseManager.equals(chosenCaseController) && chosenCaseManager.getId() != 1 && chosenCaseController.getId() != 1) {
            return false;
        }

        return casesDao.updateCaseManagerByCaseId(caseId, chosenCaseManager) &&
                casesDao.updateCaseControllerByCaseId(caseId, chosenCaseController) &&
                casesDao.updateHandledByByCaseId(caseId, chosenHandledBy);
    }

    @Transactional
    @Override
    public boolean updateCaseDecision(int caseId, CaseDecisionUpdateRequest request){

        CaseManager currentCaseManager = casesDao.getCaseManagerByCaseId(caseId);
        CaseManager chosenCaseController = caseManagerDao.getCaseManagerById(request.getCaseControllerId());

        if (currentCaseManager.equals(chosenCaseController) || chosenCaseController.getId() == 1 || request.getJustification().isBlank()) {
            return false;
        }

        return casesDao.updateCaseControllerByCaseId(caseId, chosenCaseController) &&
                casesDao.updateJustificationByCaseId(caseId, request.getJustification()) &&
                casesDao.updateCaseDecisionResultByCaseId(caseId, caseDecisionResultDao.getCaseDecisionResultById(request.getCaseDecisionResultId()));
    }

    public CaseEntity createCaseWithMockData() {
        CaseEntity caseEntity = new CaseEntity();

        caseEntity.setName("test");
        caseEntity.setCaseManager(caseManagerDao.getCaseManagerById(2));
        caseEntity.setCaseController(caseManagerDao.getCaseManagerById(3));
        caseEntity.setHandledBy(caseManagerDao.getCaseManagerById(1));
        caseEntity.setCaseStatus(CaseStatus2.UNHANDLED);
        caseEntity.setCaseDecisionType(CaseDecisionType2.APPLICATION_APPROVAL);
        caseEntity.setOrganization(organizationDao.getOrganizationByCaseId(1));
        caseEntity.setSupportTypeNode(supportTypeNodeDao.getSupportTypeNodeById(1L));

        caseEntity.setFieldValues(caseEntity.getSupportTypeNode().getFieldDefinitions()
                .stream()
                .<AbstractFieldValue<? extends FieldDefinition>>
                        map(fdn -> fdn.createFieldValue(caseEntity))
                .toList());

        // BEHÖVDE LÄGGA TILL  cascade = CascadeType.ALL på budgetRows och financingRows i BudgetFieldValue för annars sparas inte dessa vid save(caseEntity)
        BudgetFieldValue budget = (BudgetFieldValue) caseEntity.getFieldValues().stream().filter(field -> field.getFieldDefinition().getFieldType() == FieldType.BUDGET).findFirst().orElseThrow(() -> new IllegalArgumentException("no budget field found"));

        budget.getBudgetRows().add(new BudgetRow(budget, 1000, CostType.TYPE_4, 2000, "little description"));
        Organization org = organizationDao.getOrganizationByCaseId(1);
        budget.getFinancingRows().add(new FinancingRow(budget, org, 500, 50, FinancingType.CASH));

        HistoryLogFieldValue historyLog = (HistoryLogFieldValue) caseEntity.getFieldValues().stream().filter(field -> field.getFieldDefinition().getFieldType() == FieldType.HISTORY_LOG).findFirst().orElseThrow(() -> new IllegalArgumentException("no history field found"));
        historyLog.getHistoryEvents().add(new HistoryEvent2(historyLog, "Event details", LocalDate.now(), HistoryEventType.ASSESSMENT_CHANGE));

        DecisionFieldValue decision = (DecisionFieldValue) caseEntity.getFieldValues().stream().filter(field -> field.getFieldDefinition().getFieldType() == FieldType.DECISION).findFirst().orElseThrow(() -> new IllegalArgumentException("no decision field found"));
        decision.setDecisionResultType(DecisionResultType.REJECTED);
        decision.setMotivation("no motivation just no");

        return caseEntityDao.save(caseEntity);
    }

    @Override
    public CaseEntity getCaseEntityById(Long id){
        return caseEntityDao.getById(id);
    }
}
