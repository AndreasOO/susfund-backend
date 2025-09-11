package flyway.util

import java.sql.Connection

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
