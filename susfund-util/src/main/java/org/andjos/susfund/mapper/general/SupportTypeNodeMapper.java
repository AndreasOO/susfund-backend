package org.andjos.susfund.mapper.general;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.SupportTypeNodeDao;
import org.andjos.susfund.dto.SupportTypeNodeDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.mapper.DtoToEntityMapper;
import org.andjos.susfund.mapper.EntityToDtoMapper;

@ApplicationScoped
public class SupportTypeNodeMapper implements GeneralMapper<SupportTypeNode, SupportTypeNodeDTO> {

    @Inject
    SupportTypeNodeDao supportTypeNodeDao;

    @Override
    public SupportTypeNodeDTO mapToDTO(SupportTypeNode entity) {
        if (entity == null) return null;
        return new SupportTypeNodeDTO(
                entity.getId(),
                entity.getTechName()
        );
    }

    @Override
    public SupportTypeNode mapToEntity(SupportTypeNodeDTO dto) {
        return supportTypeNodeDao.getSupportTypeNodeById(dto.getId());
    }
}
