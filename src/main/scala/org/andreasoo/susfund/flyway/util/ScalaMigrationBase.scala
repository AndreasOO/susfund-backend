package org.andreasoo.susfund.flyway.util

import org.flywaydb.core.api.migration.{BaseJavaMigration, Context}

import java.sql.{Connection, ResultSet}

abstract class ScalaMigrationBase extends BaseJavaMigration {


  def migrate(connection: Connection): Unit


  final override def migrate(context: Context): Unit = {
    migrate(context.getConnection)
  }

  protected def execute(connection: Connection, sql: String): Unit = {
    val statement = connection.createStatement()
    try {
      statement.execute(sql)
    } finally {
      statement.close()
    }
  }
}
