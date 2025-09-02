package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.AssessmentFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.assessment.AssessmentFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

@ApplicationScoped
public class AssessmentFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<AssessmentFieldValue, AssessmentFieldValueDTO> {

    @Override
    public AssessmentFieldValueDTO mapToDTO(AssessmentFieldValue fieldValue, Long caseId) {
        return new AssessmentFieldValueDTO(
                caseId,
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getAssessmentScore(),
                fieldValue.getAssessmentJustification()
        );
    }
}

