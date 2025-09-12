package service.impl;

import dto.SimpleCaseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import entity.casemanager.CaseManager;
import entity.organization.Organization;
import entity.caseentity.CaseEntity;
import entity.supporttype.SupportTypeNode;
import mapper.EntityToDtoMapper;
import mapper.general.CaseEntityMapper;
import mapper.general.CaseManagerMapper;
import mapper.general.OrganizationMapper;
import mapper.general.SupportTypeNodeMapper;
import service.GeneralMappingService;

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
