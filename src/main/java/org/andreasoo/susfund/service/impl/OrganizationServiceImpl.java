package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dao.OrganizationDao;
import org.andreasoo.susfund.entity.Organization;
import org.andreasoo.susfund.service.OrganizationService;

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
