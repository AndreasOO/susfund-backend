package org.andjos.susfund.statemachine.transition

import org.andjos.susfund.entity.caseentity.CaseEntity
import org.andjos.susfund.statemachine.paremeter.ParameterType
import org.andjos.susfund.statemachine.state.DecisionRoundState
import org.andjos.susfund.statemachine.trigger.Trigger

import java.util
import java.util.List

trait Transition {
  def validate(caseEntity:CaseEntity, trigger:Trigger, paramType:ParameterType, param:util.List[Object]): Unit = {
    println("validating")
  }
  def performAction(caseEntity:CaseEntity, trigger:Trigger, paramType:ParameterType, param:util.List[Object]): Unit = {
    validate(caseEntity,trigger,paramType,param)
    execute(caseEntity,trigger,paramType,param)
  }
  def execute(caseEntity:CaseEntity, trigger:Trigger, paramType:ParameterType, param:util.List[Object]):Unit

  def getNextDecisionRoundState(caseEntity: CaseEntity): DecisionRoundState = {

  }

}
