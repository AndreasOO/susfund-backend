package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.updated.CaseEntity;

import java.util.List;

public interface CaseEntityDao {
    CaseEntity getById(Long id);
    CaseEntity save(CaseEntity caseEntity);
    List<CaseEntity> getAll();
}
