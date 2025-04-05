package org.andreasoo.susfund.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.andreasoo.susfund.entity.CaseApplication;
import org.andreasoo.susfund.entity.QuestionResult;
import org.andreasoo.susfund.util.ApplicationUtil;

import java.util.List;

@ApplicationScoped
public class CaseApplicationDaoImpl implements CaseApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ApplicationUtil getApplicationUtilByCaseId(int caseId) {
        CaseApplication caseApplication = entityManager.createQuery(
                "select ca from Cases c join c.caseApplication ca where c.id=" + caseId,CaseApplication.class).getSingleResult();

        ApplicationUtil applicationUtil = new ApplicationUtil();
        applicationUtil.setCaseApplicationId(caseApplication.getId());

        List<List<QuestionResult>> result =
                caseApplication
                        .getQuestionResults()
                        .stream()
                        .map(res1 -> res1.getApplicationQuestion().getApplicationSection().getId())
                        .distinct()
                        .map(sectionId -> caseApplication.getQuestionResults()
                                                                    .stream()
                                                                    .filter(res2 -> res2.getApplicationQuestion().getApplicationSection().getId() == sectionId)
                                                                    .toList())
                        .toList();
        applicationUtil.setQuestionResults(result);
        return applicationUtil;
    }

    @Transactional
    public void updateQuestionResultById(int caseId, int questionResultId, String updatedAnswer){
        CaseApplication caseApplication = entityManager.find(CaseApplication.class, caseId);
        caseApplication.getQuestionResults().get(questionResultId).setAnswer(updatedAnswer);
        entityManager.merge(caseApplication);
    }
}
