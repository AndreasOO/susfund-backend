package org.andjos.susfund.statemachine

import org.andjos.susfund.entity.caseentity.CaseEntity
import org.andjos.susfund.statemachine.state.DecisionRoundState
import org.andjos.susfund.statemachine.transition.Transition
import org.andjos.susfund.statemachine.trigger.Trigger

import java.util
import java.util.Map


object StateMachine {


  def apply(caseEntity:CaseEntity, stateMap:util.Map[DecisionRoundState, util.Map[Trigger, Transition]]): Unit = {
      new StateMachine(caseEntity, stateMap)
  }
}

private class StateMachine(val caseEntity: CaseEntity,
                           val stateMap:util.Map[DecisionRoundState, util.Map[Trigger, Transition]])
  extends DefaultStateMachine {




}
