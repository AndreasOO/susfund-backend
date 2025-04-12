package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.entity.CaseStatus;
import org.andreasoo.susfund.entity.Organization;

@ApplicationScoped
public class OrganizationDaoImpl implements OrganizationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Organization getOrganizationByCaseId(int caseId) {
        return entityManager.createQuery(
                "select o from Cases c join c.organization o where c.id=" + caseId, Organization.class).getSingleResult();
    }
}
