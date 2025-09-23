package org.andjos.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.dao.OrganizationDao;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.service.OrganizationService;

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
