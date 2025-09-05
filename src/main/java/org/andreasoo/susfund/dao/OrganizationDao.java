package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.Organization;

import java.util.List;

public interface OrganizationDao {
    Organization getOrganizationByCaseId(int caseId);

    List<Organization> getAllOrganizations();
}
