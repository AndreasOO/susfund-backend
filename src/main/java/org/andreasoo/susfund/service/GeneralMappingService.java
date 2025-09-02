package org.andreasoo.susfund.service;

import org.andreasoo.susfund.dto.CaseDTO;
import org.andreasoo.susfund.dto.CaseManagerDTO;
import org.andreasoo.susfund.dto.OrganizationDTO;
import org.andreasoo.susfund.dto.SupportTypeNodeDTO;
import org.andreasoo.susfund.entity.old.CaseManager;
import org.andreasoo.susfund.entity.old.Organization;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode;

import java.util.List;

public interface GeneralMappingService {
    <E, D> D mapToDTO(E entity);
    <E, D> List<D> mapListToDTO(List<E> entities);
    CaseDTO mapCaseToDTO(CaseEntity entity);
    OrganizationDTO mapOrganizationToDTO(Organization entity);
    CaseManagerDTO mapCaseManagerToDTO(CaseManager entity);
    SupportTypeNodeDTO mapSupportTypeNodeToDTO(SupportTypeNode entity);
}
