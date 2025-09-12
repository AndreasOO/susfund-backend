package mapper.general;

import dto.CaseManagerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.casemanager.CaseManager;
import mapper.EntityToDtoMapper;

@ApplicationScoped
public class CaseManagerMapper implements EntityToDtoMapper<CaseManager, CaseManagerDTO> {

    @Override
    public CaseManagerDTO mapToDTO(CaseManager entity) {
        if (entity == null) return null;
        return new CaseManagerDTO(
                entity.getId(),
                entity.getName()
        );
    }
}
