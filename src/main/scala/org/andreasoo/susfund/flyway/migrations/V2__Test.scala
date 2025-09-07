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

import java.sql.{Connection, ResultSet}
import java.time.LocalDate
import java.util.stream.Collectors

class V2__Test extends ScalaMigrationBase {

  private def getLastInsertId(connection: Connection):Long = {
    val result: ResultSet = connection.createStatement().executeQuery("SELECT LAST_INSERT_ID() as id")

    val id = try {
      if (result.next()) {
        result.getLong("id")
      } else {
        throw new RuntimeException("Failed to get generated ID")
      }
    } finally {
      result.getStatement.close()
      result.close()
    }
    id
  }

  override def migrate(connection: Connection): Unit = {

    val stn = new SupportTypeNode
    stn.setTechName("FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE")

    execute(connection,
    "INSERT INTO support_type_node (tech_name) VALUES ('FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE')")

    val supportTypeNodeId:Long = getLastInsertId(connection)

    println(s"support type node: $supportTypeNodeId")





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
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('APPLICATION_QUESTION', 'APPLICATION', 'flyway title', 'flyway preamble', 'flyway assisting text', true, 1, 'MAIN_VIEW', 'SUSTAINABILITY', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId1:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId1, $supportTypeNodeId)")


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

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('ASSESSMENT_QUESTION', 'ASSESSMENT', 'flyway title2', 'flyway preamble2', 'flyway assisting text2', true, 2, 'MAIN_VIEW', 'FINANCING', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId2:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId2, $supportTypeNodeId)")

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

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE, budget_type) " +
        "VALUES ('BUDGET', 'BUDGET', 'flyway title3', 'flyway preamble3', 'flyway assisting text3', false, 3, 'MAIN_VIEW', 'SIMPLE_FIELD_DEFINITION', 'NORMAL')")
    val fieldDefId3:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId3, $supportTypeNodeId)")


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

    // DETTA SKULLE VARA DECISION FIELD VALUE, INTE ASSESSMENT
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('DECISION', 'DECISION', 'flyway title2', 'flyway preamble2', 'flyway assisting text2', true, 2, 'MAIN_VIEW', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId4:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId4, $supportTypeNodeId)")

    // SELECTABLE VALUES
    execute(connection,
    "INSERT INTO selectable_value (selectable_type, value) VALUES ('CASE_DECISION', 'APPROVED')")
    val slv1:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO fdn_slv (field_definition_id, selectable_value_id) VALUES ($fieldDefId4, $slv1)")

    execute(connection,
      "INSERT INTO selectable_value (selectable_type, value) VALUES ('CASE_DECISION', 'REJECTED')")
    val slv2:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO fdn_slv (field_definition_id, selectable_value_id) VALUES ($fieldDefId4, $slv2)")

    execute(connection,
      "INSERT INTO selectable_value (selectable_type, value) VALUES ('CASE_DECISION', 'PARTIALLY APPROVED')")
    val slv3:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO fdn_slv (field_definition_id, selectable_value_id) VALUES ($fieldDefId4, $slv3)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, has_comment, row_index, frontend_location) VALUES ('NUMERIC_FIELD', 'DECISION', false, 2, 'MAIN_VIEW')")
    val fieldDefId5:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId5, $supportTypeNodeId)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, has_comment, row_index, frontend_location) VALUES ('DATE_FIELD', 'DECISION', false, 1, 'MAIN_VIEW')")
    val fieldDefId6:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId6, $supportTypeNodeId)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, has_comment, row_index, frontend_location) VALUES ('HISTORY_LOG', 'HISTORY', 'History title', false, 1, 'MAIN_VIEW')")
    val fieldDefId7:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId7, $supportTypeNodeId)")

    // CASE
    execute(connection,
      s"INSERT INTO case_entity (name, organization_id, case_manager_id, case_controller_id, handled_by_id, case_status, case_decision_type, support_type_node_id) VALUES ('Test case', 2, 3, 1, 'UNHANDLED', 'APPLICATION_APPROVAL', 1, $supportTypeNodeId)")
    val case1Id:Long = getLastInsertId(connection)

    //FIELD VALUES
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, string_value, last_updated, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId1, $case1Id, 'Application string value', ${LocalDate.now()}, 'TEXT')")
    val applicationFieldVal:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, assessment_justification, assessment_score, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId2, $case1Id, ${LocalDate.now()}, 'Assessment justification text', 3, 'ASSESSMENT_RESULT')")
    val assessmentFieldVal:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, decision_date, decision_result_type, decision_motivation, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId4, $case1Id, ${LocalDate.now()}, ${LocalDate.now()}, 'REJECTED', 'This is the motivation', 'DECISION')")
    val decisionFieldVal:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, numeric_value, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId5, $case1Id, ${LocalDate.now()}, 6, 'NUMERIC')")
    val numericFieldVal:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, date_value, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId6, $case1Id, ${LocalDate.now()}, ${LocalDate.now()}, 'DATE')")
    val dateFieldVal:Long = getLastInsertId(connection)


    // HISTORY LOG FIELD VALUE + LOG ROWS
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, event_details, last_updated, event_date) VALUES ($fieldDefId7, $case1Id, 'History log details', ${LocalDate.now()}, ${LocalDate.now()})")
    val historyLogVal:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO history_event2 (field_value_entity_id, history_event_type, history_event_date, history_event_details) VALUES ($historyLogVal, 'ASSESSMENT_CHANGE', ${LocalDate.now()}, 'History event details')")
    val historyEventId1:Long = getLastInsertId(connection)

    // BUDGET FIELD VALUE + ROWS
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, total_financing_ratio, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId3, $case1Id, ${LocalDate.now()}, 50, 'BUDGET')")
    val budgetFieldVal:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO financing_row (field_value_entity_id, organization_id, financing_amount, financing_percentage, financing_type) VALUES ($budgetFieldVal, 1, 500, 50, 'CASH')")
    val financingRowId1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO budget_row (field_value_entity_id, estimated_cost, cost_type, accrued_cost, description) VALUES ($budgetFieldVal, 1000, 'TYPE_4', 1500, 'Budget row description')")
    val budgetRowId1:Long = getLastInsertId(connection)



  }
}
