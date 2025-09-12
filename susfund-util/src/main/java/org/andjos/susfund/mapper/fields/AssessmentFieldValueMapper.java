package org.andjos.susfund.mapper.fields;

import org.andjos.susfund.dto.fieldvalue.AssessmentFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.assessment.AssessmentFieldValue;

@ApplicationScoped
public class AssessmentFieldValueMapper
        implements FieldValueMapper<AssessmentFieldValue, AssessmentFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public AssessmentFieldValueDTO mapToDTO(AssessmentFieldValue fieldValue) {
        return new AssessmentFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getAssessmentScore(),
                fieldValue.getAssessmentJustification()
        );
    }
}

