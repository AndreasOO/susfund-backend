package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="assessment_item")
public class AssessmentItem implements Serializable {

    public AssessmentItem() {
    }

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="assessment_section_id")
    private AssessmentSection assessmentSection;

    private String title;
    private String preamble;

    @Column(name="assisting_text")
    private String assistingText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AssessmentSection getAssessmentSection() {
        return assessmentSection;
    }

    public void setAssessmentSection(AssessmentSection assessmentSection) {
        this.assessmentSection = assessmentSection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

    public String getAssistingText() {
        return assistingText;
    }

    public void setAssistingText(String assistingText) {
        this.assistingText = assistingText;
    }




    @Override
    public String toString() {
        return "AssessmentItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
