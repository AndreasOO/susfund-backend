package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.DecisionFieldValueDTO;
import org.andreasoo.susfund.entity.field.value.decision.DecisionFieldValue;

@ApplicationScoped
public class DecisionFieldValueMapper
        implements FieldValueMapper<DecisionFieldValue, DecisionFieldValueDTO>,
                   FieldDefinitionDTOFactory {

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
}
