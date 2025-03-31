package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.entity.AssessmentResult;
import org.andreasoo.susfund.entity.CaseAssessment;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.util.AssessmentUtil;

import java.util.List;

@ApplicationScoped
public class CaseAssessmentDaoImpl implements CaseAssessmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AssessmentUtil getAssessmentUtilByCaseId(int caseId) {
        //TODO WORKS BUT VIOLATES SINGLE RESPONSIBILITY PRINCIPLE: FIX WITH JPQL
        CaseAssessment caseAssessment = entityManager.find(Cases.class, caseId).getCaseAssessment();

        AssessmentUtil assessmentUtil = new AssessmentUtil();
        assessmentUtil.setCaseAssessmentId(caseAssessment.getId());

        List<List<AssessmentResult>> result =
                caseAssessment.getAssessmentResults().stream()
                        .map(res1 -> res1.getAssessmentItem().getAssessmentSection().getId())
                        .distinct()
                        .map(sectionId -> caseAssessment.getAssessmentResults().stream()
                                .filter(res2 -> res2.getAssessmentItem().getAssessmentSection().getId() == sectionId)
                                .toList())
                        .toList();
        assessmentUtil.setAssessmentResults(result);
        return assessmentUtil;
    }
}
