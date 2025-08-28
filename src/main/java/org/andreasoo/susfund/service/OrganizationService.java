package org.andreasoo.susfund.service;

import org.andreasoo.susfund.entity.old.Organization;

import java.util.List;

public interface OrganizationService {

    Organization getOrganizationById(int id);

    List<Organization> getAllOrganizations();
}
