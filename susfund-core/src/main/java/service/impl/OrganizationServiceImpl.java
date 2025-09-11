package service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import dao.OrganizationDao;
import entity.organization.Organization;
import service.OrganizationService;

import java.util.List;

@ApplicationScoped
public class OrganizationServiceImpl implements OrganizationService {

    @Inject
    private OrganizationDao organizationDao;

    @Override
    public Organization getOrganizationById(int id) {
        return organizationDao.getOrganizationByCaseId(id);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationDao.getAllOrganizations();
    }
}
