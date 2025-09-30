package org.andjos.susfund.statemachine

import org.andjos.susfund.entity.caseentity.CaseEntity
import org.andjos.susfund.statemachine.paremeter.ParameterType
import org.andjos.susfund.statemachine.state.DecisionRoundState
import org.andjos.susfund.statemachine.transition.Transition
import org.andjos.susfund.statemachine.trigger.Trigger

import java.util
import java.util.Map


object DefaultStateMachine {
  def apply(caseEntity:CaseEntity, stateMap:util.Map[DecisionRoundState, util.Map[Trigger, Transition]]): Unit = {
      new DefaultStateMachine(caseEntity, stateMap)
  }
}



 class DefaultStateMachine(
                            val caseEntity: CaseEntity,
                            val stateMap:util.Map[DecisionRoundState, util.Map[Trigger, Transition]])
  extends StateMachine {


   override protected def doTransition(trigger: Trigger, param: ParameterType, objects: util.List[Object]): Unit = {

     val decisionRoundState:DecisionRoundState = new DecisionRoundState(caseEntity.getCaseDecisionType, caseEntity.getCaseStatus)

     val possibleTransitions:util.Map[Trigger, Transition] = stateMap.get(decisionRoundState)

     if (possibleTransitions == null) {
       throw new RuntimeException("No possible transitions for decision round state")
     }

     val transition:Transition = possibleTransitions.get(trigger)


     if (transition == null) {
       throw new RuntimeException(s"No transition found for trigger: $trigger")
     }

     transition.validate(caseEntity,trigger,param, objects)
     transition.performAction(caseEntity,trigger,param, objects)
    }

 }
