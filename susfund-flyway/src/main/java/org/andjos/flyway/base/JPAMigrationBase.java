package org.andjos.flyway.base;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for JPA-based Flyway migrations.
 * Provides EntityManager functionality for migrations that need to work with JPA entities
 * instead of raw SQL statements.
 */
public abstract class JPAMigrationBase extends BaseJavaMigration {

    private static final Logger logger = LoggerFactory.getLogger(JPAMigrationBase.class);
    private static EntityManagerFactory emf;

    @Override
    public final void migrate(Context context) throws Exception {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            // Get or create EntityManagerFactory
            if (emf == null) {
                emf = createEntityManagerFactory(context);
            }

            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            logger.info("Starting JPA migration: {}", this.getClass().getSimpleName());

            migrate(em);

            transaction.commit();
            logger.info("Successfully completed JPA migration: {}", this.getClass().getSimpleName());

        } catch (Exception e) {
            logger.error("Error during JPA migration: {}", this.getClass().getSimpleName(), e);
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    protected abstract void migrate(EntityManager entityManager) throws Exception;


    private EntityManagerFactory createEntityManagerFactory(Context context) throws SQLException {
        Map<String, String> properties = new HashMap<>();

        String jdbcUrl = "jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

        // Hibernate properties for standalone usage
        properties.put("jakarta.persistence.jdbc.url", jdbcUrl);
        properties.put("jakarta.persistence.jdbc.user", "${DB_USERNAME}");
        properties.put("jakarta.persistence.jdbc.password", "${DB_PASSWORD}");
        properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

        // Hibernate-specific properties
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "none"); // Don't auto-create schema
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.connection.autocommit", "false");

        // Create EntityManagerFactory
        return Persistence.createEntityManagerFactory("susfund-flyway-pu", properties);
    }

    public static void cleanup() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }
}