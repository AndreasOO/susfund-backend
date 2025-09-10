package org.andreasoo.susfund.dto;

import org.andreasoo.susfund.entity.caseentity.CaseDecisionType;
import org.andreasoo.susfund.entity.caseentity.CaseStatus;

public class SimpleCaseDTO extends AbstractDTO {

    private Long id;
    private String name;
    private String companyName;
    private String caseManager;
    private String caseController;
    private CaseStatus caseStatus;
    private CaseDecisionType caseDecisionType;

    public SimpleCaseDTO() {
        super("simpleCase");

    }

    public SimpleCaseDTO(Long id, String name, String companyName,
                         String caseManager, String caseController,
                         CaseStatus caseStatus, CaseDecisionType caseDecisionType) {
        super("simpleCase");
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.caseManager = caseManager;
        this.caseController = caseController;
        this.caseStatus = caseStatus;
        this.caseDecisionType = caseDecisionType;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(String caseManager) {
        this.caseManager = caseManager;
    }

    public String getCaseController() {
        return caseController;
    }

    public void setCaseController(String caseController) {
        this.caseController = caseController;
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

}
