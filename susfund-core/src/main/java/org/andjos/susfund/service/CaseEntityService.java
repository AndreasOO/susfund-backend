package org.andjos.susfund.service;

import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.entity.caseentity.CaseEntity;

import java.util.List;

public interface CaseEntityService {

    List<CaseEntity> getAllCaseEntities();

    Organization getOrganizationByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int id);

    List<CaseManager> getCaseManagers();

    CaseEntity getCaseEntityById(Long id);
}
