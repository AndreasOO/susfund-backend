package dao;

import entity.caseentity.CaseEntity;

import java.util.List;

public interface CaseEntityDao {
    CaseEntity getById(Long id);
    CaseEntity save(CaseEntity caseEntity);
    List<CaseEntity> getAll();
}
