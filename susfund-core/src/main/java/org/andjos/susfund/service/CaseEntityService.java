package org.andjos.susfund.service;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.entity.caseentity.CaseEntity;

import java.util.List;

public interface CaseEntityService {

    List<CaseEntity> getAllCaseEntities();

    Organization getOrganizationByCaseId(int id);

    CaseManager getCaseManagerByCaseId(int id);

    List<CaseManager> getCaseManagers();

    CaseEntity getCaseEntityById(Long id);

    void saveFields(Long caseId, List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fieldValues);

}
