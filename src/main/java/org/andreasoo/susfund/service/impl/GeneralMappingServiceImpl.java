package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dto.CaseDTO;
import org.andreasoo.susfund.dto.CaseManagerDTO;
import org.andreasoo.susfund.dto.OrganizationDTO;
import org.andreasoo.susfund.dto.SupportTypeNodeDTO;
import org.andreasoo.susfund.entity.old.CaseManager;
import org.andreasoo.susfund.entity.old.Organization;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;
import org.andreasoo.susfund.service.FieldValueMappingService;
import org.andreasoo.susfund.service.GeneralMappingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class GeneralMappingServiceImpl implements GeneralMappingService {

    private final FieldValueMappingService fieldValueMappingService;

    // Registry of entity to DTO mappers
    private final Map<Class<?>, EntityToDtoMapper<?, ?>> mappers = new HashMap<>();

    @Inject
    public GeneralMappingServiceImpl(FieldValueMappingService fieldValueMappingService) {
        this.fieldValueMappingService = fieldValueMappingService;
        initializeMappers();
    }

    private void initializeMappers() {
        // Register case mapper
        mappers.put(CaseEntity.class, (EntityToDtoMapper<CaseEntity, CaseDTO>) this::mapCaseToDTO);

        // Register organization mapper
        mappers.put(Organization.class, (EntityToDtoMapper<Organization, OrganizationDTO>) this::mapOrganizationToDTO);

        // Register case manager mapper
        mappers.put(CaseManager.class, (EntityToDtoMapper<CaseManager, CaseManagerDTO>) this::mapCaseManagerToDTO);

        // Register support type node mapper
        mappers.put(SupportTypeNode.class, (EntityToDtoMapper<SupportTypeNode, SupportTypeNodeDTO>) this::mapSupportTypeNodeToDTO);

        // Add more mappers as needed...
    }

    // Generic mapping method
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

    // Generic list mapping method
   @Override
    public <E, D> List<D> mapListToDTO(List<E> entities) {
        if (entities == null || entities.isEmpty()) return new ArrayList<>();
        return entities.stream()
                .map(this::<E, D>mapToDTO)
                .collect(Collectors.toList());
    }

    // Specific mapping implementations
    public CaseDTO mapCaseToDTO(CaseEntity entity) {
        if (entity == null) return null;

        return new CaseDTO(
                entity.getId(),
                entity.getName(),
                mapOrganizationToDTO(entity.getOrganization()),
                mapCaseManagerToDTO(entity.getCaseManager()),
                mapCaseManagerToDTO(entity.getCaseController()),
                mapCaseManagerToDTO(entity.getHandledBy()),
                entity.getCaseStatus(),
                entity.getCaseDecisionType(),
                mapSupportTypeNodeToDTO(entity.getSupportTypeNode()),
                fieldValueMappingService.mapFieldValuesToDTOs(entity.getFieldValues(), entity.getId())
        );
    }

    public OrganizationDTO mapOrganizationToDTO(Organization entity) {
        if (entity == null) return null;
        return new OrganizationDTO(
                entity.getId(),
                entity.getName(),
                entity.getOrganizationType().getName()
        );
    }

    public CaseManagerDTO mapCaseManagerToDTO(CaseManager entity) {
        if (entity == null) return null;
        return new CaseManagerDTO(
                entity.getId(),
                entity.getName()
        );
    }

    public SupportTypeNodeDTO mapSupportTypeNodeToDTO(SupportTypeNode entity) {
        if (entity == null) return null;
        return new SupportTypeNodeDTO(
                entity.getId(),
                entity.getTechName()
        );
    }
}
