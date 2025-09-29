package org.andjos.susfund.statemachine.transition

import jakarta.inject.Inject
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO
import org.andjos.susfund.entity.caseentity.CaseEntity
import org.andjos.susfund.entity.field.definition.FieldDefinition
import org.andjos.susfund.entity.field.value.AbstractFieldValue
import org.andjos.susfund.service.FieldDefinitionService
import org.andjos.susfund.statemachine.paremeter.ParameterType
import org.andjos.susfund.statemachine.trigger.Trigger

import java.util
import java.util.List
import java.util.stream.Collectors
import scala.jdk.CollectionConverters.{CollectionHasAsScala, IterableHasAsJava}

class SaveFieldsTransition extends Transition {

  @Inject
  private var fieldService:FieldDefinitionService = _

  override def execute(caseEntity: CaseEntity, trigger: Trigger, paramType: ParameterType, param: util.List[Object]): Unit = {
       // In real application: create case version and save
       val fieldValues = param.stream()
         .map[AbstractFieldValueDTO[_ <: FieldDefinitionDTO]](obj => obj.asInstanceOf[AbstractFieldValueDTO[_ <: FieldDefinitionDTO]])
         .collect(Collectors.toList())

    updateFields(fieldValues)

  }

  protected def updateFields(fieldValues: util.List[AbstractFieldValueDTO[_ <: FieldDefinitionDTO]]): Unit = {
    fieldService.saveFields(fieldValues)
  }
}
