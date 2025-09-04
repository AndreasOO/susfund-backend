package org.andreasoo.susfund.flyway.util

import org.flywaydb.core.api.migration.{BaseJavaMigration, Context}

import java.sql.{Connection, ResultSet}

/**
 * Base class for Scala-based Flyway migrations
 * Provides utility methods and Scala-friendly interfaces for database operations
 */
abstract class ScalaMigrationBase extends BaseJavaMigration {

  /**
   * Abstract method that subclasses must implement to define their migration logic
   */
  def migrate(connection: Connection): Unit

  /**
   * Final implementation of the Flyway migrate method
   * Delegates to the Scala-friendly migrate method
   */
  final override def migrate(context: Context): Unit = {
    migrate(context.getConnection)
  }

  /**
   * Execute a SQL statement
   */
  protected def execute(connection: Connection, sql: String): Unit = {
    val statement = connection.createStatement()
    try {
      statement.execute(sql)
    } finally {
      statement.close()
    }
  }

  /**
   * Execute multiple SQL statements
   */
  protected def executeBatch(connection: Connection, sqls: String*): Unit = {
    sqls.foreach(sql => execute(connection, sql))
  }

  /**
   * Execute a prepared statement with parameters
   */
  protected def executePrepared(connection: Connection, sql: String, params: Any*): Unit = {
    val statement = connection.prepareStatement(sql)
    try {
      params.zipWithIndex.foreach { case (param, index) =>
        param match {
          case s: String => statement.setString(index + 1, s)
          case i: Int => statement.setInt(index + 1, i)
          case l: Long => statement.setLong(index + 1, l)
          case d: Double => statement.setDouble(index + 1, d)
          case b: Boolean => statement.setBoolean(index + 1, b)
          case bd: java.math.BigDecimal => statement.setBigDecimal(index + 1, bd)
          case ts: java.sql.Timestamp => statement.setTimestamp(index + 1, ts)
          case date: java.sql.Date => statement.setDate(index + 1, date)
          case null => statement.setNull(index + 1, java.sql.Types.NULL)
          case _ => statement.setObject(index + 1, param)
        }
      }
      statement.execute()
    } finally {
      statement.close()
    }
  }

  /**
   * Query database and process results with a function
   */
  protected def query[T](connection: Connection, sql: String)(processor: ResultSet => T): T = {
    val statement = connection.createStatement()
    try {
      val resultSet = statement.executeQuery(sql)
      try {
        processor(resultSet)
      } finally {
        resultSet.close()
      }
    } finally {
      statement.close()
    }
  }

  /**
   * Check if a table exists
   */
  protected def tableExists(connection: Connection, tableName: String): Boolean = {
    val meta = connection.getMetaData
    val resultSet = meta.getTables(null, null, tableName.toUpperCase, Array("TABLE"))
    try {
      resultSet.next()
    } finally {
      resultSet.close()
    }
  }

  /**
   * Check if a column exists in a table
   */
  protected def columnExists(connection: Connection, tableName: String, columnName: String): Boolean = {
    val meta = connection.getMetaData
    val resultSet = meta.getColumns(null, null, tableName.toUpperCase, columnName.toUpperCase)
    try {
      resultSet.next()
    } finally {
      resultSet.close()
    }
  }

  /**
   * Drop table if it exists
   */
  protected def dropTableIfExists(connection: Connection, tableName: String): Unit = {
    execute(connection, s"DROP TABLE IF EXISTS `$tableName`")
  }

  /**
   * Create table with SQL
   */
  protected def createTable(connection: Connection, tableName: String, definition: String): Unit = {
    execute(connection, s"CREATE TABLE `$tableName` ($definition)")
  }

  /**
   * Add column to table
   */
  protected def addColumn(connection: Connection, tableName: String, columnDefinition: String): Unit = {
    execute(connection, s"ALTER TABLE `$tableName` ADD COLUMN $columnDefinition")
  }

  /**
   * Drop column from table
   */
  protected def dropColumn(connection: Connection, tableName: String, columnName: String): Unit = {
    execute(connection, s"ALTER TABLE `$tableName` DROP COLUMN `$columnName`")
  }

  /**
   * Create index
   */
  protected def createIndex(connection: Connection, indexName: String, tableName: String, columns: String*): Unit = {
    val columnList = columns.map(c => s"`$c`").mkString(", ")
    execute(connection, s"CREATE INDEX `$indexName` ON `$tableName` ($columnList)")
  }

  /**
   * Create unique index
   */
  protected def createUniqueIndex(connection: Connection, indexName: String, tableName: String, columns: String*): Unit = {
    val columnList = columns.map(c => s"`$c`").mkString(", ")
    execute(connection, s"CREATE UNIQUE INDEX `$indexName` ON `$tableName` ($columnList)")
  }

  /**
   * Drop index
   */
  protected def dropIndex(connection: Connection, tableName: String, indexName: String): Unit = {
    execute(connection, s"DROP INDEX `$indexName` ON `$tableName`")
  }
}
