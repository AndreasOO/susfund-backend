package org.andreasoo.susfund.mapper.general;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.SupportTypeNodeDTO;
import org.andreasoo.susfund.entity.supporttype.SupportTypeNode;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;

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
