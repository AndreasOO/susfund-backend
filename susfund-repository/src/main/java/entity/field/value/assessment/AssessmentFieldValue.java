package entity.field.value.assessment;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import entity.caseentity.CaseEntity;
import entity.field.definition.FieldDefinition;
import entity.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="ASSESSMENT_RESULT")
public class AssessmentFieldValue extends AbstractFieldValue<FieldDefinition> {

    public AssessmentFieldValue() {
        super();
    }

    public AssessmentFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

    //TODO make column
    @Column(name="assessment_score")
    private Integer assessmentScore;

    //TODO make column
    @Column(name="assessment_justification")
    private String assessmentJustification;

    @Override
    public String getValueAsString() {
        return "";
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
