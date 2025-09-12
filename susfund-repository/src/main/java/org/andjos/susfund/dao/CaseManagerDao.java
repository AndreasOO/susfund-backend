package org.andjos.susfund.dao;

import org.andjos.susfund.entity.casemanager.CaseManager;

import java.util.List;

public interface CaseManagerDao {
    CaseManager getCaseManagerByCaseId(int caseId);
    List<CaseManager> getAllCaseManagers();
    CaseManager getCaseManagerById(int id);
}
