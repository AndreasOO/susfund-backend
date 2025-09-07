package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dto.*;
import org.andreasoo.susfund.entity.old.CaseManager;
import org.andreasoo.susfund.entity.old.Organization;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;
import org.andreasoo.susfund.mapper.general.CaseEntityMapper;
import org.andreasoo.susfund.mapper.general.CaseManagerMapper;
import org.andreasoo.susfund.mapper.general.OrganizationMapper;
import org.andreasoo.susfund.mapper.general.SupportTypeNodeMapper;
import org.andreasoo.susfund.service.FieldValueMappingService;
import org.andreasoo.susfund.service.GeneralMappingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
