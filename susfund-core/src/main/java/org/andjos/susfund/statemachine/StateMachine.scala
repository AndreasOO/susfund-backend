package org.andjos.susfund.statemachine

import org.andjos.susfund.statemachine.paremeter.ParameterType
import org.andjos.susfund.statemachine.trigger.Trigger

import java.util

trait StateMachine {

  // denna metod anropas i service
  def handleTrigger(trigger:Trigger, param:ParameterType, objects:util.List[_]): Unit = {
    doTransition(trigger,param,objects.asInstanceOf[util.List[Object]])
  }

  protected def doTransition(trigger:Trigger, param:ParameterType, objects:util.List[Object])

}
