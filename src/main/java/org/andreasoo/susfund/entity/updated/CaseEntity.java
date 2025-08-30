package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="case_entity")
public class CaseEntity implements Serializable {
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
    @JoinColumn(name="case_controller_id")
    private CaseManager caseController;

    @ManyToOne
    @JoinColumn(name="handled_by_id")
    private CaseManager handledBy;

    @ManyToOne
    @JoinColumn(name="case_status_id")
    private CaseStatus caseStatus;

    // TODO: NEW, NEED TO CREATE TABLE AND INSERT VALUES
    @Column(name="case_decision_type")
    @Enumerated(EnumType.STRING)
    private CaseDecisionType2 caseDecisionType;

    @OneToMany(mappedBy = "owningCase")
    private List <AbstractFieldValue<? extends FieldDefinition>> fieldValues;
//    @ManyToOne
//    @JoinColumn(name="case_decision_id")
//    private CaseDecision caseDecision;

//    @ManyToOne
//    @JoinColumn(name="case_application_id")
//    private CaseApplication caseApplication;
//
//    @ManyToOne
//    @JoinColumn(name="case_assessment_id")
//    private CaseAssessment caseAssessment;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name="cases_id")
//    private List<HistoryEvent> historyEventList;

//    @OneToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="case_budget_id")
//    private CaseBudget caseBudget;

    public CaseEntity() {
    }

    public CaseEntity(int id, String name, Organization organization, CaseManager caseManager) {
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

    public CaseManager getCaseController() {
        return caseController;
    }

    public void setCaseController(CaseManager caseController) {
        this.caseController = caseController;
    }

    public CaseManager getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(CaseManager handledBy) {
        this.handledBy = handledBy;
    }

    public CaseDecisionType2 getCaseDecisionType() {
        return caseDecisionType;
    }

    public void setCaseDecisionType(CaseDecisionType2 caseDecisionType) {
        this.caseDecisionType = caseDecisionType;
    }

    public List<AbstractFieldValue<? extends FieldDefinition>> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<AbstractFieldValue<? extends FieldDefinition>> fieldValues) {
        this.fieldValues = fieldValues;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
