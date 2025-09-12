package org.andjos.susfund.dao;

import org.andjos.susfund.entity.organization.Organization;

import java.util.List;

public interface OrganizationDao {
    Organization getOrganizationByCaseId(int caseId);
    List<Organization> getAllOrganizations();
}
