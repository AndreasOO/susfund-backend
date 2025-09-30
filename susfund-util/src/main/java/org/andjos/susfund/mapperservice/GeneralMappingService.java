package org.andjos.susfund.mapperservice;

import org.andjos.susfund.dto.SimpleCaseDTO;
import org.andjos.susfund.entity.caseentity.CaseEntity;

public interface GeneralMappingService {
    <E, D> D mapToDTO(E entity);
    <D, E> E mapToEntity(D dto);
    SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity);
}
