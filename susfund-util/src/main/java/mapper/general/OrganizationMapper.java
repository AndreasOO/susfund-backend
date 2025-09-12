package mapper.general;

import dto.OrganizationDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.organization.Organization;
import mapper.EntityToDtoMapper;

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
