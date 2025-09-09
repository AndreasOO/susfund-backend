package org.andreasoo.susfund.service;

import jakarta.transaction.Transactional;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.CaseEntity;

import java.util.List;

public interface CaseEntityService {

    List<CaseEntity> getAllCaseEntities();

    Organization getOrganizationByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int id);

    List<CaseManager> getCaseManagers();

    CaseEntity getCaseEntityById(Long id);
}
