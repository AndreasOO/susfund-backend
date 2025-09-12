package org.andjos.susfund.service;

import org.andjos.susfund.entity.organization.Organization;

import java.util.List;

public interface OrganizationService {

    Organization getOrganizationById(int id);

    List<Organization> getAllOrganizations();
}
