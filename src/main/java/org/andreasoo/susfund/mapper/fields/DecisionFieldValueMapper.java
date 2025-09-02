package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.DecisionFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

@ApplicationScoped
public class DecisionFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<DecisionFieldValue, DecisionFieldValueDTO> {

    @Override
    public DecisionFieldValueDTO mapToDTO(DecisionFieldValue fieldValue, Long caseId) {
        return new DecisionFieldValueDTO(
                caseId,
                createSelectableFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getDecisionResultType()
        );
    }
}
