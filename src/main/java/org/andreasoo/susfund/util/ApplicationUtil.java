package org.andreasoo.susfund.util;

import org.andreasoo.susfund.entity.old.QuestionResult;

import java.util.List;

public class ApplicationUtil {
    private int caseApplicationId;
    private List<List<QuestionResult>> questionResults;

    public ApplicationUtil() {
    }

    public Integer getCaseApplicationId() {
        return caseApplicationId;
    }

    public void setCaseApplicationId(int caseApplicationId) {
        this.caseApplicationId = caseApplicationId;
    }

    public List<List<QuestionResult>> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<List<QuestionResult>> questionResults) {
        this.questionResults = questionResults;
    }
}
