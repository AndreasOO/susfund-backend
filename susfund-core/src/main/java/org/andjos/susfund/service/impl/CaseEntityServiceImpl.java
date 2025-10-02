package org.andjos.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.dao.*;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.service.CaseEntityService;
import org.andjos.susfund.statemachine.StateMachine;
import org.andjos.susfund.statemachine.paremeter.ParameterType;
import org.andjos.susfund.statemachine.state.DecisionRoundState;
import org.andjos.susfund.statemachine.trigger.Trigger;
import org.andjos.susfund.statemachine.util.SupportTypeUtil;

import java.util.List;

@ApplicationScoped
public class CaseEntityServiceImpl implements CaseEntityService {

    @Inject
    private OrganizationDao organizationDao;

    @Inject
    private CaseManagerDao caseManagerDao;

    @Inject
    private FieldDefinitionDao fieldDefinitionDao;

    @Inject
    private CaseEntityDao caseEntityDao;

    @Inject
    private SupportTypeNodeDao supportTypeNodeDao;

    @Inject
    private SupportTypeUtil supportTypeUtil;


    @Override
    public List<CaseEntity> getAllCaseEntities() {
        return caseEntityDao.getAll();
    }

    @Override
    public Organization getOrganizationByCaseId(int id) {
        return organizationDao.getOrganizationByCaseId(id);
    }

    @Override
    public CaseManager getCaseManagerByCaseId(int id) {
        return caseManagerDao.getCaseManagerByCaseId(id);
    }

    @Override
    public List<CaseManager> getCaseManagers() {
        return caseManagerDao.getAllCaseManagers();
    }

    @Override
    public CaseEntity getCaseEntityById(Long id){
        return caseEntityDao.getById(id);
    }

    @Override
    public void saveFields(Long caseId, List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fieldValues){

        StateMachine stateMachine = supportTypeUtil.getCaseStateMachine(caseEntityDao.getById(caseId));

        stateMachine.handleTrigger(Trigger.SAVE_FIELDS, ParameterType.FIELDS, fieldValues);

    }

    @Override
    public void updateCaseDecisionRoundState(Long id) {
        StateMachine stateMachine = supportTypeUtil.getCaseStateMachine(caseEntityDao.getById(id));
        stateMachine.handleTrigger(Trigger.NEXT_DECISION_ROUND_STATE, ParameterType.NONE, List.of());
    }

    @Override
    public void executeDecisionRoundStateTransition(Long id, DecisionRoundState decisionRoundState){
        CaseEntity caseEntity = caseEntityDao.getById(id);
        caseEntity.setCaseStatus(decisionRoundState.getCaseStatus());
        caseEntity.setCaseDecisionType(decisionRoundState.getCaseDecisionType());
        caseEntityDao.save(caseEntity);
    }
}
