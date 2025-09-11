package service;

import entity.caseentity.CaseEntity;

public interface GeneralMappingService {
    <E, D> D mapToDTO(E entity);

    SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity);
}
