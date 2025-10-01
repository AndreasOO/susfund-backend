package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;

public class AssessmentFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Integer assessmentScore;
    private String assessmentJustification;

    protected AssessmentFieldValueDTO() {
        super();
    }

    protected AssessmentFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "assessmentFieldValue");
    }

    public AssessmentFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Integer assessmentScore, String assessmentJustification) {
        super(id, owningCaseId, owningFieldDefinition, "assessmentFieldValue");
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
