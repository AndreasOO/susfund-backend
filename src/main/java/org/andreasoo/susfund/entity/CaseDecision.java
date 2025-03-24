package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

@Entity
@Table(name="case_decision")

public class CaseDecision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn (name="case_decision_result_id")
    private CaseDecisionResult result;

    public CaseDecision() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CaseDecisionResult getResult() {
        return result;
    }

    public void setResult(CaseDecisionResult result) {
        this.result = result;
    }
}
