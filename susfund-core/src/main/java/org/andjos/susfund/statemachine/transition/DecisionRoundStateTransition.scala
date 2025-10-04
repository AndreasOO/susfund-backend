package org.andjos.susfund.statemachine.transition
import jakarta.inject.Inject
import org.andjos.susfund.dao.CaseEntityDao
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO
import org.andjos.susfund.entity.caseentity.CaseEntity
import org.andjos.susfund.service.{CaseEntityService, FieldDefinitionService}
import org.andjos.susfund.statemachine.paremeter.ParameterType
import org.andjos.susfund.statemachine.state.DecisionRoundState
import org.andjos.susfund.statemachine.trigger.Trigger
import org.andjos.susfund.statemachine.util.SupportTypeUtil

import java.util
import java.util.Map

class DecisionRoundStateTransition extends Transition {

  @Inject
  private var supportTypeUtil:SupportTypeUtil = _

  @Inject
  private var caseDao:CaseEntityDao = _

  override def execute(caseEntity: CaseEntity, trigger: Trigger, paramType: ParameterType, param: util.List[Object]): Unit = {

    val decisionRoundStateMap:util.Map[DecisionRoundState, DecisionRoundState] = supportTypeUtil.getNextDecisionRoundStateMap

    val currentDecisionRoundState:DecisionRoundState =  new DecisionRoundState(caseEntity.getCaseDecisionType, caseEntity.getCaseStatus)
    val nextDecisionRoundState:DecisionRoundState = decisionRoundStateMap.get(currentDecisionRoundState)

    updateDecisionRoundState(caseEntity, nextDecisionRoundState)
  }

  protected def updateDecisionRoundState(caseEntity:CaseEntity, nextDecisionRoundState: DecisionRoundState): Unit = {
    caseEntity.setCaseStatus(nextDecisionRoundState.getCaseStatus)
    caseEntity.setCaseDecisionType(nextDecisionRoundState.getCaseDecisionType)
    caseDao.save(caseEntity)
  }
}
