package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

@Entity
@Table(name="case_decision_type")

public class CaseDecisionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    public CaseDecisionType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
