package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.CaseManager;
import org.andreasoo.susfund.entity.Organization;

import java.util.List;

public interface CaseManagerDao {
    CaseManager getCaseManagerByCaseId(int caseId);
    List<CaseManager> getAllCaseManagers();
    CaseManager getCaseManagerById(int id);
}
