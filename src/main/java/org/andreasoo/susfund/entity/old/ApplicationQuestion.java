package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="application_question")
public class ApplicationQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String preamble;

    @Column(name="assisting_text")
    private String assistingText;

    @ManyToOne
    @JoinColumn(name="application_section_id")
    private ApplicationSection applicationSection;


    public ApplicationQuestion() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAssistingText(String assisting_text) {
        this.assistingText = assisting_text;
    }

    public ApplicationSection getApplicationSection() {
        return applicationSection;
    }

    public void setApplicationSection(ApplicationSection applicationSection) {
        this.applicationSection = applicationSection;
    }
}
