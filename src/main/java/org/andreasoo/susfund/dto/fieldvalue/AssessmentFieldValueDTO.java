package org.andreasoo.susfund.dto.fieldvalue;

import jakarta.persistence.Column;
import org.andreasoo.susfund.dto.AbstractDTO;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;

public class AssessmentFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Integer assessmentScore;
    private String assessmentJustification;

    protected AssessmentFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition);
    }

    public AssessmentFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Integer assessmentScore, String assessmentJustification) {
        super(owningCaseId, owningFieldDefinition);
        this.assessmentScore = assessmentScore;
        this.assessmentJustification = assessmentJustification;
    }

    public Integer getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(Integer assessmentScore) {
        this.assessmentScore = assessmentScore;
    }

    public String getAssessmentJustification() {
        return assessmentJustification;
    }

    public void setAssessmentJustification(String assessmentJustification) {
        this.assessmentJustification = assessmentJustification;
    }
}
