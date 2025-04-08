package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.Organization;

public interface OrganizationDao {
    Organization getOrganizationByCaseId(int caseId);
}
