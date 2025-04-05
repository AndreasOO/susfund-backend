package org.andreasoo.susfund.service;


import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.dao.*;
import org.andreasoo.susfund.entity.*;
import org.andreasoo.susfund.util.ApplicationUtil;
import org.andreasoo.susfund.util.AssessmentUpdateRequest;
import org.andreasoo.susfund.util.AssessmentUtil;
import org.andreasoo.susfund.util.QuestionUpdateRequest;

import java.util.List;



@Path("/cases")
public class CasesResource {

    @Inject
    private CasesDao casesDao;

    @Inject
    private CaseAssessmentDao caseAssessmentDao;

    @Inject
    private CaseApplicationDao caseApplicationDao;

    @Inject
    private CaseBudgetDao caseBudgetDao;

    @Inject
    private CaseDecisionDao caseDecisionDao;

    @Inject
    private CaseStatusDao caseStatusDao;

    @Inject
    private CaseDecisionTypeDao caseDecisionTypeDao;

    @Inject
    private OrganizationDao organizationDao;

    @Inject
    private HistoryEventDao historyEventDao;

    @Inject
    private CaseManagerDao caseManagerDao;

    @GET
    @Produces("application/json")
    public List<Cases> getAllCases() {
        return casesDao.getAllCases();
    }
    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public Cases getCaseById(@PathParam("id") int id) {
        return casesDao.getCaseById(id);
    }

    @Path("/{id}/assessment")
    @GET()
    @Produces("application/json")
    public AssessmentUtil getAssessmentUtilByCaseId(@PathParam("id") int id) {
        return caseAssessmentDao.getAssessmentUtilByCaseId(id);
    }

    @Path("/{id}/assessment")
    @POST()
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAssessmentResultById(@PathParam("id") int caseId, AssessmentUpdateRequest request) {
        try{
            caseAssessmentDao.updateAssessmentResultById(caseId, request);
            return Response.ok().entity("Answer updated successfully").build();
        }
        catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @Path("/{id}/application")
    @GET()
    @Produces("application/json")
    public ApplicationUtil getApplicationUtilByCaseId(@PathParam("id") int id) {
        return caseApplicationDao.getApplicationUtilByCaseId(id);
    }

    // osäker på path, vad metoden ska returnera till frontend, samt felhantering
    @Path("/{id}/application")
    @POST()
    @Consumes("application/json")
    @Produces("application/json")
    public Response getQuestionResultById(@PathParam("id") int caseId, QuestionUpdateRequest request) {
        try{
            caseApplicationDao.updateQuestionResultById(caseId, request);
            return Response.ok().entity("Answer updated successfully").build();
        }
        catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }


    @Path("/{id}/budget")
    @GET()
    @Produces("application/json")
    public CaseBudget getCaseBudgetByCaseId(@PathParam("id") int id) {
        return caseBudgetDao.getCaseBudgetByCaseId(id);
    }

    @Path("/{id}/decision")
    @GET()
    @Produces("application/json")
    public CaseDecision getCaseDecisionByCaseId(@PathParam("id") int id) {
        return caseDecisionDao.getCaseDecisionByCaseId(id);
    }

    @Path("/{id}/status")
    @GET()
    @Produces("application/json")
    public CaseStatus getCaseStatusByCaseId(@PathParam("id") int id) {
        return caseStatusDao.getCaseStatusByCaseId(id);
    }

    @Path("/{id}/decisiontype")
    @GET()
    @Produces("application/json")
    public CaseDecisionType getCaseDecisionTypeByCaseId(@PathParam("id") int id) {
        return caseDecisionTypeDao.getCaseDecisionTypeByCaseId(id);
    }

    @Path("/{id}/organization")
    @GET()
    @Produces("application/json")
    public Organization getOrganizationByCaseId(@PathParam("id") int id) {
        return organizationDao.getOrganizationByCaseId(id);
    }

    @Path("/{id}/history")
    @GET()
    @Produces("application/json")
    public List<HistoryEvent> getHistoryEventsByCaseId(@PathParam("id") int id) {
        return historyEventDao.getHistoryEventsByCaseId(id);
    }

    @Path("/{id}/casemanager")
    @GET()
    @Produces("application/json")
    public CaseManager getCaseManagerByCaseId(@PathParam("id") int id) {
        return caseManagerDao.getCaseManagerByCaseId(id);
    }

    @Path("/casemanagers")
    @GET()
    @Produces("application/json")
    public List<CaseManager> getCaseManagers() {
        return caseManagerDao.getAllCaseManagers();
    }
}