package org.andreasoo.susfund.flyway.init;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Flyway initializer that runs database migrations on application startup
 * This CDI bean ensures migrations are executed before the application starts serving requests
 */
@Singleton
@Startup
public class FlywayInitializer {

    private static final Logger LOGGER = Logger.getLogger(FlywayInitializer.class.getName());

    @PostConstruct
    public void initializeFlyway() {
        try {

            /*
            connection-url="jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", \
            driver-name="mysql", \
            enabled="true", \
            user-name="${DB_USERNAME}", \
            password="${DB_PASSWORD}", \
             */

            LOGGER.info("Starting Flyway database migrations...");

            // Build database URL from environment variables (matching docker-compose)
            String dbHost = System.getenv().getOrDefault("DB_HOST", "${DB_HOST}");
            String dbPort = System.getenv().getOrDefault("DB_PORT", "${DB_PORT}");
            String dbName = System.getenv().getOrDefault("DB_NAME", "${DB_NAME}");
            String dbUsername = System.getenv().getOrDefault("DB_USERNAME", "${DB_USERNAME}");
            String dbPassword = System.getenv().getOrDefault("DB_PASSWORD", "${DB_PASSWORD}");

            String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    dbHost, dbPort, dbName);

            LOGGER.info(String.format("Connecting to database: %s", jdbcUrl));

            // Configure Flyway
            Flyway flyway = Flyway.configure()
                    .dataSource(jdbcUrl, dbUsername, dbPassword)
                    .locations("classpath:org/andreasoo/susfund/flyway/migrations")
                    .baselineOnMigrate(true)
                    .validateOnMigrate(true)
                    .cleanDisabled(false) // Allow clean in development
                    .loggers("slf4j") // Use SLF4J for logging
                    .load();

            // Get current migration info
            var migrationInfo = flyway.info();
            LOGGER.info(String.format("Current schema version: %s",
                    migrationInfo.current() != null ? migrationInfo.current().getVersion() : "Empty database"));

//            for (var migration : flyway.info().all()) {
//                LOGGER.info(String.format("BEFORE MIGRATE Migration found: version=%s, description=%s, type=%s, script=%s, state=%s",
//                        migration.getVersion(),
//                        migration.getDescription(),
//                        migration.getType(),
//                        migration.getScript(),
//                        migration.getState()));
//            }

            // Run migrations
            var result = flyway.migrate();

            if (result.success) {
                LOGGER.info(String.format("Successfully applied %d migrations. New schema version: %s",
                        result.migrationsExecuted,
                        result.targetSchemaVersion != null ? result.targetSchemaVersion : "Latest"));
            } else {
                LOGGER.severe("Flyway migration failed!");
                throw new RuntimeException("Database migration failed");
            }

            // Log all migration info for debugging
            LOGGER.info("Migration status:");
            for (var info : flyway.info().all()) {
                LOGGER.info(String.format("  %s: %s - %s (%s)",
                        info.getVersion(),
                        info.getDescription(),
                        info.getState(),
                        info.getInstalledOn()));
            }

        } catch (FlywayException e) {
            LOGGER.log(Level.SEVERE, "Flyway migration error: " + e.getMessage(), e);
            throw new RuntimeException("Failed to initialize database migrations", e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Flyway migration error: " + e.getMessage(), e);
        }
    }
    }