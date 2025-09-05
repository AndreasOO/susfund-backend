package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.updated.CaseEntity;

public interface CaseEntityDao {
    CaseEntity getById(Long id);
    CaseEntity save(CaseEntity caseEntity);
}
