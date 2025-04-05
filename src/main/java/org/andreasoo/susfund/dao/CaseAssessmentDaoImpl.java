package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.entity.AssessmentResult;
import org.andreasoo.susfund.entity.CaseApplication;
import org.andreasoo.susfund.entity.CaseAssessment;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.util.AssessmentUpdateRequest;
import org.andreasoo.susfund.util.AssessmentUtil;
import org.andreasoo.susfund.util.QuestionUpdateRequest;

import java.util.List;

@ApplicationScoped
public class CaseAssessmentDaoImpl implements CaseAssessmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AssessmentUtil getAssessmentUtilByCaseId(int caseId) {
        CaseAssessment caseAssessment = entityManager.createQuery(
                "select ca from Cases c join c.caseAssessment ca where c.id=" + caseId,CaseAssessment.class).getSingleResult();

        AssessmentUtil assessmentUtil = new AssessmentUtil();
        assessmentUtil.setCaseAssessmentId(caseAssessment.getId());

        List<List<AssessmentResult>> result =
                caseAssessment
                        .getAssessmentResults()
                        .stream()
                        .map(res1 -> res1.getAssessmentItem().getAssessmentSection().getId())
                        .distinct()
                        .map(sectionId -> caseAssessment.getAssessmentResults()
                                                                    .stream()
                                                                    .filter(res2 -> res2.getAssessmentItem().getAssessmentSection().getId() == sectionId)
                                                                    .toList())
                        .toList();
        assessmentUtil.setAssessmentResults(result);
        return assessmentUtil;
    }

    @Transactional
    public void updateAssessmentResultById(int caseId, AssessmentUpdateRequest request){
        CaseAssessment caseAssessment = entityManager.find(CaseAssessment.class, caseId);

        caseAssessment.getAssessmentResults().forEach(assessmentResult -> {
            if(assessmentResult.getAssessmentItem().getId() == request.getAssessmentItemId()){
                assessmentResult.setScore(request.getScore());
                assessmentResult.setJustification(request.getJustification());
            }
        });
        entityManager.merge(caseAssessment);
    }
}
