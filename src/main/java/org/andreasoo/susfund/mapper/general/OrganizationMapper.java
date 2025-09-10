package org.andreasoo.susfund.mapper.general;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.OrganizationDTO;
import org.andreasoo.susfund.entity.organization.Organization;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;

@ApplicationScoped
public class OrganizationMapper implements EntityToDtoMapper<Organization, OrganizationDTO> {

    @Override
    public OrganizationDTO mapToDTO(Organization entity) {
        if (entity == null) return null;
        return new OrganizationDTO(
                entity.getId(),
                entity.getName(),
                entity.getOrganizationType()
        );
    }
}
