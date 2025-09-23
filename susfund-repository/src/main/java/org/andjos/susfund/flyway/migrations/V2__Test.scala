package org.andjos.susfund.flyway.migrations

import org.andjos.susfund.entity.supporttype.SupportTypeNode
import org.andjos.susfund.flyway.util.ScalaMigrationBase

import java.sql.{Connection, ResultSet}

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

    // SUPPORT TYPE NODE

    execute(connection,
    "INSERT INTO support_type_node (tech_name) VALUES ('FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE')")
    val supportTypeNodeId:Long = getLastInsertId(connection)
    println(s"support type node: $supportTypeNodeId")

    // FIELD DEFINITIONS


    //application questions
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('APPLICATION_QUESTION', 'APPLICATION', 'flyway title', 'flyway preamble', 'flyway assisting text', true, 1, 'MAIN_VIEW', 'SUSTAINABILITY', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId1:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId1, $supportTypeNodeId)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('APPLICATION_QUESTION', 'APPLICATION', 'flyway title', 'flyway preamble', 'flyway assisting text', true, 2, 'MAIN_VIEW', 'ECONOMIC_FEASIBILITY', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId11:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId11, $supportTypeNodeId)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('APPLICATION_QUESTION', 'APPLICATION', 'flyway title', 'flyway preamble', 'flyway assisting text', true, 3, 'MAIN_VIEW', 'REGIONAL_GROWTH', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId12:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId12, $supportTypeNodeId)")


    //assessment questions
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('ASSESSMENT_QUESTION', 'ASSESSMENT', 'flyway title2', 'flyway preamble2', 'flyway assisting text2', true, 2, 'MAIN_VIEW', 'FINANCING', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId2:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId2, $supportTypeNodeId)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('ASSESSMENT_QUESTION', 'ASSESSMENT', 'flyway title2', 'flyway preamble2', 'flyway assisting text2', true, 2, 'MAIN_VIEW', 'COMPANY', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId21:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId21, $supportTypeNodeId)")

    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, sub_section, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('ASSESSMENT_QUESTION', 'ASSESSMENT', 'flyway title2', 'flyway preamble2', 'flyway assisting text2', true, 2, 'MAIN_VIEW', 'DECISION', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId22:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId22, $supportTypeNodeId)")


    //budget
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE, budget_type) " +
        "VALUES ('BUDGET', 'BUDGET', 'flyway title3', 'flyway preamble3', 'flyway assisting text3', false, 3, 'MAIN_VIEW', 'BUDGET', 'NORMAL')")
    val fieldDefId3:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId3, $supportTypeNodeId)")


    //selectable/decision
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, preamble, assisting_text, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE) " +
        "VALUES ('DECISION', 'DECISION', 'flyway title2', 'flyway preamble2', 'flyway assisting text2', true, 2, 'MAIN_VIEW', 'SELECTABLE')")
    val fieldDefId4:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId4, $supportTypeNodeId)")

    // SELECTABLE VALUES...
    execute(connection,
    "INSERT INTO selectable_value (selectable_type, value) VALUES ('CASE_DECISION', 'APPROVED')")
    val slv1:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO fdn_slv (field_definition_id, selectable_value_id) VALUES ($fieldDefId4, $slv1)")

    execute(connection,
      "INSERT INTO selectable_value (selectable_type, value) VALUES ('CASE_DECISION', 'REJECTED')")
    val slv2:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO fdn_slv (field_definition_id, selectable_value_id) VALUES ($fieldDefId4, $slv2)")

    execute(connection,
      "INSERT INTO selectable_value (selectable_type, value) VALUES ('CASE_DECISION', 'PARTIALLY_APPROVED')")
    val slv3:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO fdn_slv (field_definition_id, selectable_value_id) VALUES ($fieldDefId4, $slv3)")


    // numeric field
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE) VALUES ('NUMERIC_FIELD', 'DECISION', false, 2, 'MAIN_VIEW', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId5:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId5, $supportTypeNodeId)")


    // date field
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE) VALUES ('DATE_FIELD', 'DECISION', false, 1, 'MAIN_VIEW', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId6:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId6, $supportTypeNodeId)")


    // history
    execute(connection,
      "INSERT INTO field_definition_entity (field_type, section, title, has_comment, row_index, frontend_location, DISCRIMINATOR_FIELD_TYPE) VALUES ('HISTORY_LOG', 'HISTORY', 'History title', false, 1, 'MAIN_VIEW', 'SIMPLE_FIELD_DEFINITION')")
    val fieldDefId7:Long = getLastInsertId(connection)
    execute(connection, s"INSERT INTO stn_fdn (field_definition_id, support_type_node_id) VALUES ($fieldDefId7, $supportTypeNodeId)")



    // CASES

    execute(connection,
      s"INSERT INTO case_entity (name, organization_id, case_manager_id, case_controller_id, handled_by_id, case_status, case_decision_type, support_type_node_id) VALUES ('Test case 1', 1, 2, 3, 1, 'UNHANDLED', 'APPLICATION_APPROVAL', $supportTypeNodeId)")
    val case1Id:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO case_entity (name, organization_id, case_manager_id, case_controller_id, handled_by_id, case_status, case_decision_type, support_type_node_id) VALUES ('Test case 2', 2, 3, 4, 2, 'IN_WAITING', 'PAYMENT_REQUEST', $supportTypeNodeId)")
    val case2Id:Long = getLastInsertId(connection)



    //FIELD VALUES

    // application
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, string_value, last_updated, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId1, $case1Id, 'Application string value', CURRENT_DATE, 'TEXT')")
    val applicationFieldVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, string_value, last_updated, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId12, $case2Id, 'This is string value 1 in case 2', CURRENT_DATE, 'TEXT')")
    val applicationFieldVal1Case2:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, string_value, last_updated, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId11, $case2Id, 'This is string value 2 in case 2', CURRENT_DATE, 'TEXT')")
    val applicationFieldVal2Case2:Long = getLastInsertId(connection)


    // assessment
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, assessment_justification, assessment_score, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId2, $case1Id, CURRENT_DATE, 'Assessment justification text', 3, 'ASSESSMENT_RESULT')")
    val assessmentFieldVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, assessment_justification, assessment_score, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId21, $case2Id, CURRENT_DATE, 'Assessment justification text', 1, 'ASSESSMENT_RESULT')")
    val assessmentFieldVal1Case2:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, assessment_justification, assessment_score, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId22, $case2Id, CURRENT_DATE, 'Assessment justification text', 2, 'ASSESSMENT_RESULT')")
    val assessmentFieldVal2Case2:Long = getLastInsertId(connection)


    // decisions
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, decision_date, decision_result_type, decision_motivation, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId4, $case1Id, CURRENT_DATE, CURRENT_DATE, 'REJECTED', 'This is the motivation', 'DECISION')")
    val decisionFieldVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, decision_date, decision_result_type, decision_motivation, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId4, $case2Id, CURRENT_DATE, CURRENT_DATE, 'PARTIALLY_APPROVED', 'nice', 'DECISION')")
    val decisionFieldVal1Case2:Long = getLastInsertId(connection)


    // numeric values
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, numeric_value, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId5, $case1Id, CURRENT_DATE, 6, 'NUMERIC')")
    val numericFieldVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, numeric_value, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId5, $case2Id, CURRENT_DATE, 1, 'NUMERIC')")
    val numericFieldVal1Case2:Long = getLastInsertId(connection)


    //date values
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, date_value, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId6, $case1Id, CURRENT_DATE, CURRENT_DATE, 'DATE')")
    val dateFieldVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, date_value, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId6, $case2Id, CURRENT_DATE, CURRENT_DATE, 'DATE')")
    val dateFieldVal1Case2:Long = getLastInsertId(connection)


    // history log values
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId7, $case1Id, CURRENT_DATE, 'HISTORY_LOG')")
    val historyLogVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId7, $case2Id, CURRENT_DATE, 'HISTORY_LOG')")
    val historyLogVal1Case2:Long = getLastInsertId(connection)


    //history events
    execute(connection,
      s"INSERT INTO history_event (field_value_entity_id, history_event_type, history_event_date, history_event_details) VALUES ($historyLogVal1Case1, 'ASSESSMENT_CHANGE', CURRENT_DATE, 'History event details in event 1 in case 1')")
    val historyEvent1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO history_event (field_value_entity_id, history_event_type, history_event_date, history_event_details) VALUES ($historyLogVal1Case1, 'BUDGET_CHANGE', CURRENT_DATE, 'History event details in event 2 in case 1')")
    val historyEvent2Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO history_event (field_value_entity_id, history_event_type, history_event_date, history_event_details) VALUES ($historyLogVal1Case2, 'CASE_MANAGER_CHANGE', CURRENT_DATE, 'History event details in event 1 in case 2')")
    val historyEvent1Case2:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO history_event (field_value_entity_id, history_event_type, history_event_date, history_event_details) VALUES ($historyLogVal1Case2, 'AMENDMENT_REQUEST', CURRENT_DATE, 'History event details in event 2 in case 2')")
    val historyEvent2Case2:Long = getLastInsertId(connection)


    // budget field values
    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, total_financing_ratio, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId3, $case1Id, CURRENT_DATE, 50, 'BUDGET')")
    val budgetFieldVal1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO field_value_entity (field_definition_entity_id, owning_case, last_updated, total_financing_ratio, DISCRIMINATOR_FIELD_VALUE_TYPE) VALUES ($fieldDefId3, $case2Id, CURRENT_DATE, 40, 'BUDGET')")
    val budgetFieldVal1Case2:Long = getLastInsertId(connection)


    // budget and financing rows
    execute(connection,
      s"INSERT INTO financing_row (field_value_entity_id, organization_id, financing_amount, financing_percentage, financing_type) VALUES ($budgetFieldVal1Case1, 1, 500, 50, 'CASH')")
    val financingRow1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO financing_row (field_value_entity_id, organization_id, financing_amount, financing_percentage, financing_type) VALUES ($budgetFieldVal1Case2, 3, 5000, 60, 'CASH')")
    val financingRow1Case2:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO financing_row (field_value_entity_id, organization_id, financing_amount, financing_percentage, financing_type) VALUES ($budgetFieldVal1Case2, 1, 1000, 20, 'NOT_CASH')")
    val financingRow2Case2:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO budget_row (field_value_entity_id, estimated_cost, cost_type, accrued_cost, description) VALUES ($budgetFieldVal1Case1, 1000, 'TYPE_4', 1500, 'This is a budget row in case 1')")
    val budgetRow1Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO budget_row (field_value_entity_id, estimated_cost, cost_type, accrued_cost, description) VALUES ($budgetFieldVal1Case1, 400, 'TYPE_1', 400, 'This is also a budget row in case 1')")
    val budgetRow2Case1:Long = getLastInsertId(connection)

    execute(connection,
      s"INSERT INTO budget_row (field_value_entity_id, estimated_cost, cost_type, accrued_cost, description) VALUES ($budgetFieldVal1Case2, 8000, 'TYPE_2', 8000, 'This is a budget row in case 2')")
    val budgetRow1Case2:Long = getLastInsertId(connection)

  }
}
