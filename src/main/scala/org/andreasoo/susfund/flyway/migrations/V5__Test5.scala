package org.andreasoo.susfund.flyway.migrations

import org.andreasoo.susfund.flyway.util.ScalaMigrationBase

import java.sql.Connection

class V5__Test5 extends ScalaMigrationBase {

  override def migrate(connection: Connection): Unit = {
    execute(connection, "ALTER TABLE field_value_entity ADD COLUMN `decision_motivation` VARCHAR(255);")
  }
}
