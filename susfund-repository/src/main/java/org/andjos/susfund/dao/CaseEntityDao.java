package org.andjos.susfund.dao;

import org.andjos.susfund.entity.caseentity.CaseEntity;

import java.util.List;

public interface CaseEntityDao {
    CaseEntity getById(Long id);
    CaseEntity save(CaseEntity caseEntity);
    List<CaseEntity> getAll();
}
