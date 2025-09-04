package org.andreasoo.susfund.flyway.migrations

import org.andreasoo.susfund.flyway.util.ScalaMigrationBase

import java.sql.Connection

class V5__Test5 extends ScalaMigrationBase {

  /**
   * Abstract method that subclasses must implement to define their migration logic
   */
  override def migrate(connection: Connection): Unit = {
    execute(connection, "ALTER TABLE test_table_flyway3 ADD COLUMN `name3` VARCHAR(255);")
  }
}
