package org.andjos.susfund.statemachine.transition

import jakarta.inject.Inject
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO
import org.andjos.susfund.entity.caseentity.CaseEntity
import org.andjos.susfund.service.FieldDefinitionService
import org.andjos.susfund.statemachine.paremeter.ParameterType
import org.andjos.susfund.statemachine.trigger.Trigger

import java.util
import java.util.List

class SaveFieldsTransition extends Transition {

  @Inject
  var fieldService:FieldDefinitionService = _

  override def execute(caseEntity: CaseEntity, trigger: Trigger, paramType: ParameterType, param: util.List[Object]): Unit = {


  }

  protected def updateFields(fieldValues: util.List[AbstractFieldValueDTO[_ <: FieldDefinitionDTO]]): Unit = {
    fieldService.saveFields(fieldValues)
  }
}
