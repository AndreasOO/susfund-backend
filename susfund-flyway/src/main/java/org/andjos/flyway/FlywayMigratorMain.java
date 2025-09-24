package org.andjos.flyway;

import org.andjos.flyway.base.JPAMigrationBase;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;


public class FlywayMigratorMain {

    private static final Logger logger = LoggerFactory.getLogger(FlywayMigratorMain.class);

    public static void main(String[] args) {
        int exitCode = 0;

        try {
            logger.info("Starting Flyway database migrations...");


            String dbUsername = System.getenv("DB_USERNAME");
            String dbPassword = System.getenv("DB_PASSWORD");

//            String dbUsername = "${DB_USERNAME}";
//            String dbPassword = "${DB_PASSWORD}";

            String dbHost = System.getenv("DB_HOST");
            String dbPort = System.getenv("DB_PORT");
            String dbName = System.getenv("DB_NAME");

            String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                    dbHost, dbPort, dbName);

            logger.info("Connecting to database: {}", jdbcUrl);


            // Configure Flyway
            Flyway flyway = Flyway.configure()
                    .dataSource(jdbcUrl, dbUsername, dbPassword)
                    .locations("classpath:org/andjos/flyway/migrations")
                    .baselineOnMigrate(true)
                    .validateOnMigrate(true)
                    .cleanDisabled(false)
                    .loggers("slf4j")
                    .load();


            var migrationInfo = flyway.info();
            logger.info("Current schema version: {}",
                    migrationInfo.current() != null ? migrationInfo.current().getVersion() : "Empty database");


            var result = flyway.migrate();

            if (result.success) {
                logger.info("Successfully applied {} migrations. New schema version: {}",
                        result.migrationsExecuted,
                        result.targetSchemaVersion != null ? result.targetSchemaVersion : "Latest");
            } else {
                logger.error("Flyway migration failed!");
                exitCode = 1;
            }

            logger.info("Migration status:");
            for (var info : flyway.info().all()) {
                logger.info("  {}: {} - {} ({})",
                        info.getVersion(),
                        info.getDescription(),
                        info.getState(),
                        info.getInstalledOn());
            }

            if (exitCode == 0) {
                logger.info("Database migrations completed successfully");
            }

        } catch (FlywayException e) {
            logger.error("Flyway migration error: {}", e.getMessage(), e);
            exitCode = 1;
        } catch (Exception e) {
            logger.error("Migration error: {}", e.getMessage(), e);
            exitCode = 1;
        } finally {
            // Cleanup JPA resources
            JPAMigrationBase.cleanup();
        }

        System.exit(exitCode);
    }

}
