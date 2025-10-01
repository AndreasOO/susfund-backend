package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.CaseManagerDao;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.DecisionFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.field.value.decision.DecisionFieldValue;
import org.andjos.susfund.mapper.general.CaseManagerMapper;

@ApplicationScoped
public class DecisionFieldValueMapper
        implements FieldValueMapper<DecisionFieldValue, DecisionFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

    @Inject
    private CaseManagerDao caseManagerDao;

    @Inject
    private CaseManagerMapper caseManagerMapper;

    @Override
    public DecisionFieldValueDTO mapToDTO(DecisionFieldValue fieldValue) {
        return new DecisionFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createSelectableFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDecisionResultType(),
                fieldValue.getMotivation(),
                caseManagerMapper.mapToDTO(fieldValue.getDecisionController())
        );
    }


    @Override
    public DecisionFieldValue mapToEntity(DecisionFieldValueDTO dto) {
        DecisionFieldValue decisionFieldValue = (DecisionFieldValue) fieldValueDao.findById(dto.id);
        CaseManager caseManager = caseManagerDao.getCaseManagerById(dto.getDecisionController().getId());

        decisionFieldValue.setDecisionResultType(dto.getDecisionResultType());
        decisionFieldValue.setMotivation(dto.getMotivation());
        decisionFieldValue.setDecisionController(caseManager);
        return decisionFieldValue;
    }
}
