package service;

import entity.casemanager.CaseManager;
import entity.organization.Organization;
import entity.caseentity.CaseEntity;

import java.util.List;

public interface CaseEntityService {

    List<CaseEntity> getAllCaseEntities();

    Organization getOrganizationByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int id);

    List<CaseManager> getCaseManagers();

    CaseEntity getCaseEntityById(Long id);
}
