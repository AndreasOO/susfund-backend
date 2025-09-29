package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.AssessmentFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.assessment.AssessmentFieldValue;

@ApplicationScoped
public class AssessmentFieldValueMapper
        implements FieldValueMapper<AssessmentFieldValue, AssessmentFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

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

    @Override
    public AssessmentFieldValue mapToEntity(AssessmentFieldValueDTO dto) {
        AssessmentFieldValue fieldValue = (AssessmentFieldValue) fieldValueDao.findById(dto.getId());
        fieldValue.setAssessmentJustification(dto.getAssessmentJustification());
        fieldValue.setAssessmentScore(dto.getAssessmentScore());
        return fieldValue;
    }
}

