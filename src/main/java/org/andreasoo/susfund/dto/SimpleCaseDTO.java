package org.andreasoo.susfund.dto;

import org.andreasoo.susfund.entity.updated.CaseDecisionType2;
import org.andreasoo.susfund.entity.updated.CaseStatus2;

public class SimpleCaseDTO extends AbstractDTO {

    private int id;
    private String name;
    private String companyName;
    private String caseManager;
    private String caseController;
    private CaseStatus2 caseStatus;
    private CaseDecisionType2 caseDecisionType;

    public SimpleCaseDTO() {
        super("simpleCase");

    }

    public SimpleCaseDTO(int id, String name, String companyName,
                         String caseManager, String caseController,
                         CaseStatus2 caseStatus, CaseDecisionType2 caseDecisionType) {
        super("simpleCase");
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.caseManager = caseManager;
        this.caseController = caseController;
        this.caseStatus = caseStatus;
        this.caseDecisionType = caseDecisionType;
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

}
