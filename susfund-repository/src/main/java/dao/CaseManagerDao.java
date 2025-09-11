package dao;

import entity.casemanager.CaseManager;

import java.util.List;

public interface CaseManagerDao {
    CaseManager getCaseManagerByCaseId(int caseId);
    List<CaseManager> getAllCaseManagers();
    CaseManager getCaseManagerById(int id);
}
