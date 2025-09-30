package org.andjos.susfund.mapper.general;

import org.andjos.susfund.dto.OrganizationDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.mapper.DtoToEntityMapper;
import org.andjos.susfund.mapper.EntityToDtoMapper;

@ApplicationScoped
public class OrganizationMapper implements GeneralMapper<Organization, OrganizationDTO> {

    @Override
    public OrganizationDTO mapToDTO(Organization entity) {
        if (entity == null) return null;
        return new OrganizationDTO(
                entity.getId(),
                entity.getName(),
                entity.getOrganizationType()
        );
    }

    @Override
    public Organization mapToEntity(OrganizationDTO dto) {
        if (dto == null) return null;
        return new Organization(
                dto.getId(),
                dto.getName(),
                dto.getOrganizationType()
        );
    }
}
