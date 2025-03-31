package org.andreasoo.susfund.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.andreasoo.susfund.entity.AssessmentResult;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.util.AssessmentUtil;

import java.util.List;


@Path("/cases")
public class CasesResource {

    @PersistenceContext()
    private EntityManager entityManager;

    @GET
    @Produces("application/json")
    public List<Cases> getAllCases() {
        return entityManager.createNamedQuery("Cases.findAll", Cases.class).getResultList();
    }
    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public Cases getCaseById(@PathParam("id") int id) {
        return entityManager.find(Cases.class, id);
    }

    @Path("/{id}/assessment")
    @GET()
    @Produces("application/json")
    public AssessmentUtil getAssessmentUtilByCaseId(@PathParam("id") int id) {
        Cases cases = entityManager.find(Cases.class, id);
        AssessmentUtil assessmentUtil = new AssessmentUtil();
        assessmentUtil.setCaseAssessmentId(cases.getCaseAssessment().getId());

        List<List<AssessmentResult>> result =
                cases.getCaseAssessment().getAssessmentResults().stream()
                        .map(res1 -> res1.getAssessmentItem().getAssessmentSection().getId())
                        .distinct()
                        .map(sectionId -> cases.getCaseAssessment().getAssessmentResults().stream()
                                                        .filter(res2 -> res2.getAssessmentItem().getAssessmentSection().getId() == sectionId)
                                                        .toList())
                .toList();
        assessmentUtil.setAssessmentResults(result);
        return assessmentUtil;
    }
}