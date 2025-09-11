package mapper.general;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.CaseManagerDTO;
import entity.casemanager.CaseManager;
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
