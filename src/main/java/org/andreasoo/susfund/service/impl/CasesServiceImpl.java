package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.dao.*;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.CaseDecisionType2;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.CaseStatus2;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.assessment.AssessmentFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.budget.BudgetFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.textfield.TextFieldValue;
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

    @Inject
    private FieldDefinitionDao fieldDefinitionDao;

    @Inject
    private CaseEntityDao caseEntityDao;


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
        caseEntity.setCaseManager(caseManagerDao.getCaseManagerById(1));
        caseEntity.setCaseController(caseManagerDao.getCaseManagerById(1));
        caseEntity.setHandledBy(caseManagerDao.getCaseManagerById(1));
        caseEntity.setCaseStatus(CaseStatus2.UNHANDLED);
        caseEntity.setCaseDecisionType(CaseDecisionType2.APPLICATION_APPROVAL);
        caseEntity.setOrganization(organizationDao.getOrganizationByCaseId(1));

//        caseEntityDao.save(caseEntity);
//
//        caseEntity.setFieldValues(fieldDefinitionDao.getAllFieldDefinitions()
//                                                        .stream()
//                                                        .<AbstractFieldValue<? extends FieldDefinition>>map(FieldDefinition::createFieldValue)
//                                                        .toList());
//            return caseEntity;
        return caseEntityDao.save(caseEntity);
    }

    @Override
    public CaseEntity addFieldValues(){
        CaseEntity caseEntity = caseEntityDao.getById(1);

//        TextFieldValue tdf = new TextFieldValue();
//        AssessmentFieldValue afv = new AssessmentFieldValue();
//        BudgetFieldValue bfv = new BudgetFieldValue();
//        DecisionFieldValue dfv = new DecisionFieldValue();
//
//        FieldDefinition application = fieldDefinitionDao.getFieldDefinitionById(1L);
//        tdf.setOwningFieldDefinition(application);
//        tdf.setOwningCase(caseEntity);
//        caseEntity.getFieldValues().add(tdf);
//
//        FieldDefinition assessment = fieldDefinitionDao.getFieldDefinitionById(2L);
//        afv.setOwningFieldDefinition(assessment);
//        afv.setOwningCase(caseEntity);
//        caseEntity.getFieldValues().add(afv);
//
//        FieldDefinition budget = fieldDefinitionDao.getFieldDefinitionById(3L);
//        bfv.setOwningFieldDefinition(budget);
//        bfv.setOwningCase(caseEntity);
//        caseEntity.getFieldValues().add(bfv);
//
//        FieldDefinition selectable = fieldDefinitionDao.getFieldDefinitionById(4L);
//        dfv.setOwningFieldDefinition(selectable);
//        dfv.setOwningCase(caseEntity);
//        caseEntity.getFieldValues().add(dfv);

        caseEntity.setFieldValues(fieldDefinitionDao.getAllFieldDefinitions()
                .stream()
                .<AbstractFieldValue<? extends FieldDefinition>>map(fieldDefinition -> {
                    AbstractFieldValue<? extends FieldDefinition> value = fieldDefinition.createFieldValue();
                    value.setOwningCase(caseEntity);
                    return value;
                })
                .toList());
        return caseEntityDao.save(caseEntity);
    }
}
