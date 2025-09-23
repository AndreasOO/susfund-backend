package org.andjos.susfund.mapper.general;

import org.andjos.susfund.dto.SupportTypeNodeDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.mapper.EntityToDtoMapper;

@ApplicationScoped
public class SupportTypeNodeMapper implements EntityToDtoMapper<SupportTypeNode, SupportTypeNodeDTO> {

    @Override
    public SupportTypeNodeDTO mapToDTO(SupportTypeNode entity) {
        if (entity == null) return null;
        return new SupportTypeNodeDTO(
                entity.getId(),
                entity.getTechName()
        );
    }
}
