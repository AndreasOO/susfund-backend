package org.andreasoo.susfund.flyway.migrations

import jakarta.persistence.{EntityManager, Persistence}
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition
import org.andreasoo.susfund.entity.updated.field.definition.budget.{BudgetFieldDefinition, BudgetType}
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType
import org.andreasoo.susfund.entity.updated.field.definition.location.FrontendLocation
import org.andreasoo.susfund.entity.updated.field.definition.section.{Section, SubSection}
import org.andreasoo.susfund.entity.updated.field.definition.selectable.SelectableFieldDefinition
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode
import org.andreasoo.susfund.flyway.util.ScalaMigrationBase

import java.sql.Connection
import java.util.stream.Collectors

class V2__Test extends ScalaMigrationBase {


  override def migrate(connection: Connection): Unit = {

    val stn = new SupportTypeNode
    stn.setTechName("FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE")

    execute(connection,
    "INSERT INTO support_type_node (tech_name) VALUES ('FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE')")



//    val fdn1 = new FieldDefinition
//    fdn1.setFieldType(FieldType.APPLICATION_QUESTION)
//    fdn1.setSection(Section.APPLICATION)
//    fdn1.setTitle("Test Title")
//    fdn1.setPreamble("Test Preamble")
//    fdn1.setAssistingText("Test assisting text")
//    fdn1.setHasComment(true)
//    fdn1.setRowIndex(1L)
//    fdn1.setFrontendLocation(FrontendLocation.MAIN_VIEW)
//    fdn1.setSubSection(SubSection.SUSTAINABILITY)

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) VALUES ('APPLICATION_QUESTION', 'APPLICATION', 'flyway title', 'flyway preamble', 'flyway assisting text', true, 1, 'MAIN_VIEW', 'SUSTAINABILITY', 'SIMPLE_FIELD_DEFINITION')")

//
//    val fdn2 = new FieldDefinition
//    fdn2.setFieldType(FieldType.ASSESSMENT_QUESTION)
//    fdn2.setSection(Section.ASSESSMENT)
//    fdn2.setTitle("Test Title2")
//    fdn2.setPreamble("Test Preamble2")
//    fdn2.setAssistingText("Test assisting text2")
//    fdn2.setHasComment(true)
//    fdn2.setRowIndex(2L)
//    fdn2.setFrontendLocation(FrontendLocation.MAIN_VIEW)
//    fdn2.setSubSection(SubSection.FINANCING)
//
//
//
//    val fdn3 = new BudgetFieldDefinition
//    fdn3.setFieldType(FieldType.BUDGET)
//    fdn3.setSection(Section.BUDGET)
//    fdn3.setTitle("Test Title3")
//    fdn3.setPreamble("Test Preamble3")
//    fdn3.setAssistingText("Test assisting text3")
//    fdn3.setHasComment(false)
//    fdn3.setRowIndex(3L)
//    fdn3.setBudgetType(BudgetType.NORMAL)
//    fdn3.setFrontendLocation(FrontendLocation.MAIN_VIEW)
//
//
//    val fdn4 = new SelectableFieldDefinition
//    fdn4.setFieldType(FieldType.DECISION)
//    fdn4.setSection(Section.DECISION)
//    fdn4.setTitle("Test Title4")
//    fdn4.setPreamble("Test Preamble4")
//    fdn4.setAssistingText("Test assisting text4")
//    fdn4.setHasComment(true)
//    fdn4.setRowIndex(4L)
//    fdn4.setSelectableValues(em.createQuery("select slv from SelectableValue slv").getResultList.stream.collect(Collectors.toSet))
//    fdn4.setFrontendLocation(FrontendLocation.MAIN_VIEW)
//
//
//    val fdn5 = new FieldDefinition
//    fdn5.setFieldType(FieldType.NUMERIC_FIELD)
//    fdn5.setSection(Section.DECISION)
//    fdn5.setRowIndex(2L)
//    fdn5.setFrontendLocation(FrontendLocation.MAIN_VIEW)
//
//
//
//    val fdn6 = new FieldDefinition
//    fdn6.setFieldType(FieldType.DATE_FIELD)
//    fdn6.setSection(Section.DECISION)
//    fdn6.setRowIndex(1L)
//    fdn6.setFrontendLocation(FrontendLocation.MAIN_VIEW)
//
//
//
//    val fdn7 = new FieldDefinition
//    fdn7.setFieldType(FieldType.HISTORY_LOG)
//    fdn7.setSection(Section.HISTORY)
//    fdn7.setTitle("History Title")
//    fdn7.setHasComment(false)
//    fdn7.setRowIndex(1L)
//    fdn7.setFrontendLocation(FrontendLocation.MAIN_VIEW)



  }
}
