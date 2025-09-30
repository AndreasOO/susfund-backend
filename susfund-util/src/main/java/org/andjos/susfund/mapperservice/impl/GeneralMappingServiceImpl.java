package org.andjos.susfund.mapperservice.impl;

import org.andjos.susfund.dto.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.mapper.DtoToEntityMapper;
import org.andjos.susfund.mapper.EntityToDtoMapper;
import org.andjos.susfund.mapper.general.*;
import org.andjos.susfund.mapperservice.GeneralMappingService;

import java.util.Map;

@ApplicationScoped
public class GeneralMappingServiceImpl implements GeneralMappingService {

    private final Map<Class<?>, GeneralMapper<?, ?>> mappers;

    @Inject
    public GeneralMappingServiceImpl(
            CaseEntityMapper caseMapper,
            OrganizationMapper organizationMapper,
            CaseManagerMapper caseManagerMapper,
            SupportTypeNodeMapper supportTypeNodeMapper) {

        this.mappers = Map.of(
                CaseEntity.class, caseMapper,
                Organization.class, organizationMapper,
                CaseManager.class, caseManagerMapper,
                SupportTypeNode.class, supportTypeNodeMapper,
                CaseDTO.class, caseMapper,
                OrganizationDTO.class, organizationMapper,
                CaseManagerDTO.class, caseManagerMapper,
                SupportTypeNodeDTO.class, supportTypeNodeMapper
        );

    }

    @SuppressWarnings("unchecked")
    @Override
    public <E, D> D mapToDTO(E entity) {
        if (entity == null) return null;

        EntityToDtoMapper<E, D> mapper = (EntityToDtoMapper<E, D>) mappers.get(entity.getClass());
        if (mapper == null) {
            throw new IllegalArgumentException("No mapper found for entity type: " + entity.getClass().getSimpleName());
        }

        return mapper.mapToDTO(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <D, E> E mapToEntity(D dto) {
        if (dto == null) return null;

        DtoToEntityMapper<D, E> mapper = (DtoToEntityMapper<D, E>) mappers.get(dto.getClass());
        if (mapper == null) {
            throw new IllegalArgumentException("No mapper found for entity type: " + dto.getClass().getSimpleName());
        }

        return mapper.mapToEntity(dto);
    }

    @Override
    public SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity){
        if (caseEntity == null) return null;
        CaseEntityMapper mapper = (CaseEntityMapper) mappers.get(caseEntity.getClass());
        return mapper.mapToSimpleCaseDTO(caseEntity);
    }

}
