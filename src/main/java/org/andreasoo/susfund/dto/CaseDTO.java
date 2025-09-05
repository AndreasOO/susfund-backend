package org.andreasoo.susfund.dto;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.updated.CaseDecisionType2;
import org.andreasoo.susfund.entity.updated.CaseStatus2;

import java.util.List;

public class CaseDTO extends AbstractDTO {

    private Long id;
    private String name;
    private OrganizationDTO organization;
    private CaseManagerDTO caseManager;
    private CaseManagerDTO caseController;
    private CaseManagerDTO handledBy;
    private CaseStatus2 caseStatus;
    private CaseDecisionType2 caseDecisionType;
    private SupportTypeNodeDTO supportTypeNode;
    private List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fields;

    public CaseDTO() {
        super("case");

    }

    public CaseDTO(Long id, String name, OrganizationDTO organization,
                   CaseManagerDTO caseManager, CaseManagerDTO caseController,
                   CaseManagerDTO handledBy, CaseStatus2 caseStatus,
                   CaseDecisionType2 caseDecisionType, SupportTypeNodeDTO supportTypeNode,
                   List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fields) {
        super("case");
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.caseManager = caseManager;
        this.caseController = caseController;
        this.handledBy = handledBy;
        this.caseStatus = caseStatus;
        this.caseDecisionType = caseDecisionType;
        this.supportTypeNode = supportTypeNode;
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }

    public CaseManagerDTO getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(CaseManagerDTO caseManager) {
        this.caseManager = caseManager;
    }

    public CaseManagerDTO getCaseController() {
        return caseController;
    }

    public void setCaseController(CaseManagerDTO caseController) {
        this.caseController = caseController;
    }

    public CaseManagerDTO getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(CaseManagerDTO handledBy) {
        this.handledBy = handledBy;
    }

    public CaseStatus2 getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus2 caseStatus) {
        this.caseStatus = caseStatus;
    }

    public CaseDecisionType2 getCaseDecisionType() {
        return caseDecisionType;
    }

    public void setCaseDecisionType(CaseDecisionType2 caseDecisionType) {
        this.caseDecisionType = caseDecisionType;
    }

    public SupportTypeNodeDTO getSupportTypeNode() {
        return supportTypeNode;
    }

    public void setSupportTypeNode(SupportTypeNodeDTO supportTypeNode) {
        this.supportTypeNode = supportTypeNode;
    }

    public List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> getFields() {
        return fields;
    }

    public void setFields(List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> fields) {
        this.fields = fields;
    }
}
