package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.AssessmentFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.assessment.AssessmentFieldValue;

@ApplicationScoped
public class AssessmentFieldValueMapper
        implements FieldValueMapper<AssessmentFieldValue, AssessmentFieldValueDTO>,
                   BaseFieldDefinitionMapper {

    @Override
    public AssessmentFieldValueDTO mapToDTO(AssessmentFieldValue fieldValue) {
        return new AssessmentFieldValueDTO(
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getAssessmentScore(),
                fieldValue.getAssessmentJustification()
        );
    }
}

