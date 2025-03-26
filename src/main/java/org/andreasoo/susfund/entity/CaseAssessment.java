package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="case_assessment")
public class CaseAssessment implements Serializable {

    public CaseAssessment() {
    }

    @Id
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="case_assessment_assessment_item",
                joinColumns = @JoinColumn(name="case_assessment_id"),
                inverseJoinColumns = @JoinColumn(name="assessment_item_id"))
    private List<AssessmentItem> assessmentItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AssessmentItem> getAssessmentItems() {
        return assessmentItems;
    }

    public void setAssessmentItems(List<AssessmentItem> assessmentItems) {
        this.assessmentItems = assessmentItems;
    }

    @Override
    public String toString() {
        return "CaseAssessment{" +
                "id=" + id +
//                ", assessmentItems=" + assessmentItems +
                '}';
    }
}
