package mapper.general;

import dto.CaseDTO;
import dto.SimpleCaseDTO;
import dto.fielddefinition.FieldDefinitionDTO;
import dto.fieldvalue.AbstractFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import mapper.EntityToDtoMapper;
import mapperservice.FieldValueMappingService;

@ApplicationScoped
public class CaseEntityMapper implements EntityToDtoMapper<CaseEntity, CaseDTO> {

    @Inject
    private FieldValueMappingService fieldValueMappingService;

    @Inject
    private OrganizationMapper organizationMapper;

    @Inject
    private CaseManagerMapper caseManagerMapper;

    @Inject
    private SupportTypeNodeMapper supportTypeNodeMapper;


    @Override
    public CaseDTO mapToDTO(CaseEntity entity) {
        if (entity == null) return null;

        return new CaseDTO(
                entity.getId(),
                entity.getName(),
                organizationMapper.mapToDTO(entity.getOrganization()),
                caseManagerMapper.mapToDTO(entity.getCaseManager()),
                caseManagerMapper.mapToDTO(entity.getCaseController()),
                caseManagerMapper.mapToDTO(entity.getHandledBy()),
                entity.getCaseStatus(),
                entity.getCaseDecisionType(),
                supportTypeNodeMapper.mapToDTO(entity.getSupportTypeNode()),
                entity.getFieldValues().stream().<AbstractFieldValueDTO<? extends FieldDefinitionDTO>>map(fieldValueMappingService::mapFieldValueToDTO).toList()
        );
    }

    public SimpleCaseDTO mapToSimpleCaseDTO(CaseEntity entity){
        if (entity == null) return null;
        return new SimpleCaseDTO(entity.getId(),
                entity.getName(),
                entity.getOrganization().getName(),
                entity.getCaseManager().getName(),
                entity.getCaseController().getName(),
                entity.getCaseStatus(),
                entity.getCaseDecisionType());
    }
}
