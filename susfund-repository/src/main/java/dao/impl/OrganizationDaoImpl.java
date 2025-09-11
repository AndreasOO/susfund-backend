package dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import dao.OrganizationDao;
import entity.organization.Organization;

import java.util.List;

@ApplicationScoped
public class OrganizationDaoImpl implements OrganizationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Organization getOrganizationByCaseId(int caseId) {
        return entityManager.createQuery(
                "select o from CaseEntity c join c.organization o where c.id=" + caseId, Organization.class).getSingleResult();
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return entityManager.createNamedQuery("Organization.findAll", Organization.class).getResultList();
    }


}
