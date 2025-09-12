package mapperservice;

import dto.SimpleCaseDTO;
import org.andjos.susfund.entity.caseentity.CaseEntity;

public interface GeneralMappingService {
    <E, D> D mapToDTO(E entity);

    SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity);
}
