package org.andjos.susfund.mapperservice.impl;

import org.andjos.susfund.dto.SimpleCaseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.mapper.EntityToDtoMapper;
import org.andjos.susfund.mapper.general.CaseEntityMapper;
import org.andjos.susfund.mapper.general.CaseManagerMapper;
import org.andjos.susfund.mapper.general.OrganizationMapper;
import org.andjos.susfund.mapper.general.SupportTypeNodeMapper;
import org.andjos.susfund.mapperservice.GeneralMappingService;

import java.util.Map;

@ApplicationScoped
public class GeneralMappingServiceImpl implements GeneralMappingService {

    private final Map<Class<?>, EntityToDtoMapper<?, ?>> mappers;

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
                SupportTypeNode.class, supportTypeNodeMapper
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

    @Override
    public SimpleCaseDTO mapCaseToSimpleCaseDTO(CaseEntity caseEntity){
        if (caseEntity == null) return null;
        CaseEntityMapper mapper = (CaseEntityMapper) mappers.get(caseEntity.getClass());
        return mapper.mapToSimpleCaseDTO(caseEntity);
    }

}
