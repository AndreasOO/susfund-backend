package org.andjos.susfund.mapperservice;

import org.andjos.susfund.dto.SimpleCaseDTO;
import org.andjos.susfund.entity.caseentity.CaseEntity;

public interface GeneralMappingService {
    <E, D> D mapToDTO(E entity);

    SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity);
}
