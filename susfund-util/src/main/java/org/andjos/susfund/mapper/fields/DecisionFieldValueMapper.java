package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.DecisionFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.decision.DecisionFieldValue;

@ApplicationScoped
public class DecisionFieldValueMapper
        implements FieldValueMapper<DecisionFieldValue, DecisionFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

    @Override
    public DecisionFieldValueDTO mapToDTO(DecisionFieldValue fieldValue) {
        return new DecisionFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createSelectableFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDecisionResultType(),
                fieldValue.getMotivation()
        );
    }


    @Override
    public DecisionFieldValue mapToEntity(DecisionFieldValueDTO dto) {
        DecisionFieldValue decisionFieldValue = (DecisionFieldValue) fieldValueDao.findById(dto.id);
        decisionFieldValue.setDecisionResultType(dto.getDecisionResultType());
        decisionFieldValue.setMotivation(dto.getMotivation());
        return decisionFieldValue;
    }
}
