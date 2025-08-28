package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="assessment_result")
public class AssessmentResult implements Serializable {

    public AssessmentResult() {
    }

    @Id
    private int id;

    private int score;

    private String justification;


    @ManyToOne
    @JoinColumn(name="assessment_item_id")
    private AssessmentItem assessmentItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public AssessmentItem getAssessmentItem() {
        return assessmentItem;
    }

    public void setAssessmentItem(AssessmentItem assessmentItem) {
        this.assessmentItem = assessmentItem;
    }
}
