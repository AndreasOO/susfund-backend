package org.andreasoo.susfund.util;

public class AssessmentUpdateRequest {

    private int assessmentItemId;
    private int score;
    private String justification;


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

    public int getAssessmentItemId() {
        return assessmentItemId;
    }

    public void setAssessmentItemId(int assessmentItemId) {
        this.assessmentItemId = assessmentItemId;
    }
}
