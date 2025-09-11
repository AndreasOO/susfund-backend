package mapper.general;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.SupportTypeNodeDTO;
import entity.supporttype.SupportTypeNode;
import mapper.EntityToDtoMapper;

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
