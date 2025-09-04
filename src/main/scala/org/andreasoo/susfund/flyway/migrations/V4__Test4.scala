package org.andreasoo.susfund.flyway.migrations

import org.andreasoo.susfund.flyway.util.ScalaMigrationBase

import java.sql.Connection

class V4__Test4 extends ScalaMigrationBase {

  /**
   * Abstract method that subclasses must implement to define their migration logic
   */
  override def migrate(connection: Connection): Unit = {
    execute(connection, "CREATE TABLE `test_table_flyway3` " +
      "( `id` INT NOT NULL AUTO_INCREMENT," +
      " `name` VARCHAR(255) NOT NULL," +
      " PRIMARY KEY (`id`)" +
      ") ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;")
  }
}
