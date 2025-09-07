package org.andreasoo.susfund.entity.updated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name="CaseEntity.findAll",
                query="select c from CaseEntity c order by c.id"
        )
})
@Table(name="case_entity")
public class CaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name="case_status")
    @Enumerated(EnumType.STRING)
    private CaseStatus2 caseStatus;

    @Column(name="case_decision_type")
    @Enumerated(EnumType.STRING)
    private CaseDecisionType2 caseDecisionType;

    @OneToMany(mappedBy = "owningCase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <AbstractFieldValue<? extends FieldDefinition>> fieldValues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="support_type_node_id")
    private SupportTypeNode supportTypeNode;

    public CaseEntity() {
    }

    public CaseEntity(Long id, String name, Organization organization, CaseManager caseManager) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.caseManager = caseManager;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
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

    public CaseStatus2 getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus2 caseStatus) {
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

    public SupportTypeNode getSupportTypeNode() {
        return supportTypeNode;
    }

    public void setSupportTypeNode(SupportTypeNode supportTypeNode) {
        this.supportTypeNode = supportTypeNode;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
