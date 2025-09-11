package dao;

import entity.organization.Organization;

import java.util.List;

public interface OrganizationDao {
    Organization getOrganizationByCaseId(int caseId);
    List<Organization> getAllOrganizations();
}
