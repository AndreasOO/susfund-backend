package org.andreasoo.susfund.controller;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.entity.*;
import org.andreasoo.susfund.service.BudgetService;
import org.andreasoo.susfund.service.CasesService;
import org.andreasoo.susfund.util.*;


import java.util.List;
import java.util.Set;


@Stateless
@Path("/cases")
public class CasesResource {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    private CasesService casesService;

    @Inject
    private BudgetService budgetService;

    @GET
    @Produces("application/json")
    public List<Cases> getAllCases() {
        return casesService.getAllCases();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public Cases getCaseById(@PathParam("id") int id) {
        return casesService.getCaseById(id);
    }

    @Path("/{id}/assessment")
    @GET()
    @Produces("application/json")
    public AssessmentUtil getAssessmentUtilByCaseId(@PathParam("id") int id) {

        return casesService.getAssessmentUtilByCaseId(id);
    }

    @Path("/{id}/assessment")
    @PUT()
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateAssessmentItem(@PathParam("id") int caseId, AssessmentUpdateRequest request) {
        boolean update = casesService.updateAssessmentItem(caseId, request);
        if(update){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Path("/{id}/application")
    @GET()
    @Produces("application/json")
    public ApplicationUtil getApplicationUtilByCaseId(@PathParam("id") int id) {
        return casesService.getApplicationUtilByCaseId(id);
    }

    // osäker på path, vad metoden ska returnera till frontend, samt felhantering
    @Path("/{id}/application")
    @PUT()
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateApplicationQuestion(@PathParam("id") int caseId, ApplicationUpdateRequest request) {
        boolean update = casesService.updateApplicationQuestion(caseId, request);
        if(update){
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @Path("/{id}/budget")
    @GET()
    @Produces("application/json")
    public CaseBudget getCaseBudgetByCaseId(@PathParam("id") int id) {
        return casesService.getCaseBudgetByCaseId(id);
    }

    @Path("/{id}/budget")
    @PUT()
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateCaseBudgetByCaseId(@PathParam("id") int id,  CaseBudget caseBudget) {
        Result<CaseBudget> result = budgetService.updateBudget(id, caseBudget);

        if (result.success()) {
            return Response.ok(result.resultObj()).build();
        } else {
            System.out.println("logged error: " + result.error());
            return Response.status(417, result.error()).build();
        }
    }

    @Path("/{id}/decision")
    @GET()
    @Produces("application/json")
    public CaseDecision getCaseDecisionByCaseId(@PathParam("id") int id) {
        return casesService.getCaseDecisionByCaseId(id);
    }

    @Path("/{id}/status")
    @GET()
    @Produces("application/json")
    public CaseStatus getCaseStatusByCaseId(@PathParam("id") int id) {
        return casesService.getCaseStatusByCaseId(id);
    }

    @Path("/{id}/decisiontype")
    @GET()
    @Produces("application/json")
    public CaseDecisionType getCaseDecisionTypeByCaseId(@PathParam("id") int id) {
        return casesService.getCaseDecisionTypeByCaseId(id);
    }

    // Flytta till organization resource?
    @Path("/{id}/organization")
    @GET()
    @Produces("application/json")
    public Organization getOrganizationByCaseId(@PathParam("id") int id) {
        return casesService.getOrganizationByCaseId(id);
    }

    @Path("/{id}/history")
    @GET()
    @Produces("application/json")
    public List<HistoryEvent> getHistoryEventsByCaseId(@PathParam("id") int id) {
        return casesService.getHistoryEventsByCaseId(id);
    }

    @Path("/{id}/casemanager")
    @GET()
    @Produces("application/json")
    public CaseManager getCaseManagerByCaseId(@PathParam("id") int id) {
        return casesService.getCaseManagerByCaseId(id);
    }

    @Path("/casemanagers")
    @GET()
    @Produces("application/json")
    public List<CaseManager> getCaseManagers() {
        return casesService.getCaseManagers();
    }

    @Path("/casedecisions")
    @GET()
    @Produces("application/json")
    public List<CaseDecision> getCaseDecisions() {
        return casesService.getCaseDecisions();
    }

    @Path("/casedecisionresults")
    @GET()
    @Produces("application/json")
    public List<CaseDecisionResult> getCaseDecisionResults() {
        return casesService.getCaseDecisionResults();
    }

    @Path("/{id}/casesrelatedtocaseorganization")
    @GET()
    @Produces("application/json")
    public List<Cases> getCasesRelatedToCaseOrganization(@PathParam("id") int id) {
        return casesService.getCasesRelatedToCaseOrganization(id);
    }


}