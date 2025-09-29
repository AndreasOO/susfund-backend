package org.andjos.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.dao.*;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.service.CaseEntityService;

import java.util.List;

@ApplicationScoped
public class CaseEntityServiceImpl implements CaseEntityService {

    @Inject
    private OrganizationDao organizationDao;

    @Inject
    private CaseManagerDao caseManagerDao;

    @Inject
    private FieldDefinitionDao fieldDefinitionDao;

    @Inject
    private CaseEntityDao caseEntityDao;

    @Inject
    private SupportTypeNodeDao supportTypeNodeDao;


    @Override
    public List<CaseEntity> getAllCaseEntities() {
        return caseEntityDao.getAll();
    }

    @Override
    public Organization getOrganizationByCaseId(int id) {
        return organizationDao.getOrganizationByCaseId(id);
    }

    @Override
    public CaseManager getCaseManagerByCaseId(int id) {
        return caseManagerDao.getCaseManagerByCaseId(id);
    }

    @Override
    public List<CaseManager> getCaseManagers() {
        return caseManagerDao.getAllCaseManagers();
    }

    @Override
    public CaseEntity getCaseEntityById(Long id){
        return caseEntityDao.getById(id);
    }

    @Override
    public void saveFields(Long caseId, List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fieldValues){

    }

}
