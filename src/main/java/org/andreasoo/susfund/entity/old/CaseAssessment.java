package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="case_assessment")
public class CaseAssessment implements Serializable {

    public CaseAssessment() {
    }

    @Id
    private int id;

    @Column(name="assessment_date")
    private LocalDate assessmentDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="case_assessment_id")
    private List<AssessmentResult> assessmentResults;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public List<AssessmentResult> getAssessmentResults() {
        return assessmentResults;
    }

    public void setAssessmentResults(List<AssessmentResult> assessmentResults) {
        this.assessmentResults = assessmentResults;
    }

    @Override
    public String toString() {
        return "CaseAssessment{" +
                "id=" + id +
//                ", assessmentItems=" + assessmentItems +
                '}';
    }
}
