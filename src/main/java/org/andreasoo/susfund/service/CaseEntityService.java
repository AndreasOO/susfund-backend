package org.andreasoo.susfund.service;

import org.andreasoo.susfund.entity.casemanager.CaseManager;
import org.andreasoo.susfund.entity.organization.Organization;
import org.andreasoo.susfund.entity.caseentity.CaseEntity;

import java.util.List;

public interface CaseEntityService {

    List<CaseEntity> getAllCaseEntities();

    Organization getOrganizationByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int id);

    List<CaseManager> getCaseManagers();

    CaseEntity getCaseEntityById(Long id);
}
