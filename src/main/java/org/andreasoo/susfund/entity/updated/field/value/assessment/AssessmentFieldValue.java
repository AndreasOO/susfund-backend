package org.andreasoo.susfund.entity.updated.field.value.assessment;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="ASSESSMENT_RESULT")
public class AssessmentFieldValue extends AbstractFieldValue<FieldDefinition> {

    public AssessmentFieldValue() {
        super();
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
