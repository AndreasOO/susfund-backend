package org.andreasoo.susfund.service;

import org.andreasoo.susfund.dto.*;
import org.andreasoo.susfund.entity.caseentity.CaseEntity;

public interface GeneralMappingService {
    <E, D> D mapToDTO(E entity);

    SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity);
}
