package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="case_decision")

public class CaseDecision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn (name="case_decision_result_id")
    private CaseDecisionResult caseDecisionResult;

    public CaseDecision() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CaseDecisionResult getCaseDecisionResult() {
        return caseDecisionResult;
    }

    public void setCaseDecisionResult(CaseDecisionResult caseDecisionResult) {
        this.caseDecisionResult = caseDecisionResult;
    }
}
