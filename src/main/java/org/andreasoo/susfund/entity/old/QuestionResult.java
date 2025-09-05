package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="question_result")

public class QuestionResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String answer;

    @ManyToOne
    @JoinColumn(name="application_question_id")
    private ApplicationQuestion applicationQuestion;


    public QuestionResult() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ApplicationQuestion getApplicationQuestion() {
        return applicationQuestion;
    }

    public void setApplicationQuestion(ApplicationQuestion applicationQuestion) {
        this.applicationQuestion = applicationQuestion;
    }

}
