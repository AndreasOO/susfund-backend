package org.andreasoo.susfund.mapper.general;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dto.CaseDTO;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;
import org.andreasoo.susfund.service.FieldValueMappingService;

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
}
