package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(
                name="Cases.findAll",
                query="select c from Cases c order by c.id"
        )
})
@Table(name="cases")
public class Cases implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name="case_manager_id")
    private CaseManager caseManager;

    @ManyToOne
    @JoinColumn(name="case_status_id")
    private CaseStatus caseStatus;

    @ManyToOne
    @JoinColumn(name="case_decision_type_id")
    private CaseDecisionType caseDecisionType;

    @ManyToOne
    @JoinColumn(name="case_decision_id")
    private CaseDecision caseDecision;

    @ManyToOne
    @JoinColumn(name="application_id")
    private Application application;

    @ManyToOne
    @JoinColumn(name="case_assessment_id")
    private CaseAssessment caseAssessment;

    public Cases() {
    }

    public Cases(int id, String name, Organization organization, CaseManager caseManager) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.caseManager = caseManager;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public CaseManager getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(CaseManager caseManager) {
        this.caseManager = caseManager;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public CaseDecisionType getCaseDecisionType() {
        return caseDecisionType;
    }

    public void setCaseDecisionType(CaseDecisionType caseDecisionType) {
        this.caseDecisionType = caseDecisionType;
    }

    public CaseDecision getCaseDecision() {
        return caseDecision;
    }

    public void setCaseDecision(CaseDecision caseDecision) {
        this.caseDecision = caseDecision;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public CaseAssessment getCaseAssessment() {
        return caseAssessment;
    }

    public void setCaseAssessment(CaseAssessment caseAssessment) {
        this.caseAssessment = caseAssessment;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
