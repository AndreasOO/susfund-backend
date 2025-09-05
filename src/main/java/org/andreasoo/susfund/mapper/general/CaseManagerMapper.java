package org.andreasoo.susfund.mapper.general;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.CaseManagerDTO;
import org.andreasoo.susfund.entity.old.CaseManager;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;

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
