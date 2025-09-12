package mapper.fields;

import dto.fieldvalue.AssessmentFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import entity.field.value.assessment.AssessmentFieldValue;

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

