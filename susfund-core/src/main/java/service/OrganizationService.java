package service;

import entity.organization.Organization;

import java.util.List;

public interface OrganizationService {

    Organization getOrganizationById(int id);

    List<Organization> getAllOrganizations();
}
