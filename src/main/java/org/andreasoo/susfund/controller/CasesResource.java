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
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.field.definition.*;
import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetType;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.definition.location.FrontendLocation;
import org.andreasoo.susfund.entity.updated.field.definition.section.Section;
import org.andreasoo.susfund.entity.updated.field.definition.selectable.SelectableFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.section.Section;
import org.andreasoo.susfund.entity.updated.field.definition.section.SubSection;
import org.andreasoo.susfund.service.BudgetService;
import org.andreasoo.susfund.service.CasesService;
import org.andreasoo.susfund.service.FieldDefinitionService;
import org.andreasoo.susfund.util.*;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Stateless
@Path("/cases")
public class CasesResource {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    private CasesService casesService;

    @Inject
    private BudgetService budgetService;

    @Inject
    private FieldDefinitionService fieldDefinitionService;

    @GET
    @Produces("application/json")
    public List<Cases> getAllCases() {
        return casesService.getAllCases();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public Cases getCaseById(@PathParam("id") int id) {
        System.out.println(budgetService.test(id));
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

    @Path("/{id}/casecontroller")
    @GET()
    @Produces("application/json")
    public CaseManager getCaseControllerByCaseId(@PathParam("id") int id) {
        return casesService.getCaseControllerByCaseId(id);
    }

    @Path("/{id}/handledby")
    @GET()
    @Produces("application/json")
    public CaseManager getHandledByByCaseId(@PathParam("id") int id) {
        return casesService.getHandledByByCaseId(id);
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

    @Path("/{id}/casemanager")
    @PUT()
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateCaseAssigmentByCaseId(@PathParam("id") int caseId, CaseAssignmentUpdateRequest payload){
        boolean update = casesService.updateCaseAssignment(caseId, payload.getCaseManagerId(), payload.getCaseControllerId(), payload.getHandledById());
        if(update){
            return Response.ok().entity(Collections.singletonMap("message", "Case assignments were successfully updated.")).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).entity(Collections.singletonMap("error", "The assigned case manager and case controller must be different. Please review your selections.")).build();
        }
    }


    @Path("/{id}/casedecision")
    @PUT()
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateCaseDecisionByCaseId(@PathParam("id") int caseId, CaseDecisionUpdateRequest payload){
        boolean update = casesService.updateCaseDecision(caseId, payload);
        if(update){
            return Response.ok().entity(Collections.singletonMap("message", "Case decision was successfully updated.")).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).entity(Collections.singletonMap("error", "Please look over following fields: Case controller can not be unassigned and must be different from the assigned case manager. Justification can not be blank")).build();
        }
    }

    @Path("/fields")
    @GET()
    @Produces("application/json")
    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitionService.getAllFieldDefinitions();
    }

    @Path("/createfields")
    @GET()
    @Produces("application/json")
    public Response createFieldDefinition() {

        FieldDefinition fdn1 = new FieldDefinition();
        fdn1.setFieldType(FieldType.APPLICATION_QUESTION);
        fdn1.setSection(Section.APPLICATION);
        fdn1.setTitle("Test Title");
        fdn1.setPreamble("Test Preamble");
        fdn1.setAssistingText("Test assisting text");
        fdn1.setHasComment(true);
        fdn1.setRowIndex(1L);
        fdn1.setFrontendLocation(FrontendLocation.MAIN_VIEW);
        fdn1.setSubSection(SubSection.SUSTAINABILITY);


        FieldDefinition fdn2 = new FieldDefinition();
        fdn2.setFieldType(FieldType.ASSESSMENT_QUESTION);
        fdn2.setSection(Section.ASSESSMENT);
        fdn2.setTitle("Test Title2");
        fdn2.setPreamble("Test Preamble2");
        fdn2.setAssistingText("Test assisting text2");
        fdn2.setHasComment(true);
        fdn2.setRowIndex(2L);
        fdn2.setFrontendLocation(FrontendLocation.MAIN_VIEW);
        fdn2.setSubSection(SubSection.FINANCING);


        BudgetFieldDefinition fdn3 = new BudgetFieldDefinition();
        fdn3.setFieldType(FieldType.BUDGET);
        fdn3.setSection(Section.BUDGET);
        fdn3.setTitle("Test Title3");
        fdn3.setPreamble("Test Preamble3");
        fdn3.setAssistingText("Test assisting text3");
        fdn3.setHasComment(false);
        fdn3.setRowIndex(3L);
        fdn3.setBudgetType(BudgetType.NORMAL);
        fdn3.setFrontendLocation(FrontendLocation.MAIN_VIEW);


//        fieldDefinitionService.createSelectableValues(
//                Set.of(new SelectableValue(SelectableType.CASE_DECISION, "Approved", null),
//                        new SelectableValue(SelectableType.CASE_DECISION, "Rejected", null),
//                        new SelectableValue(SelectableType.CASE_DECISION,"Partially Approved", null)).stream().toList()
//        );

        SelectableFieldDefinition fdn4 = new SelectableFieldDefinition();
        fdn4.setFieldType(FieldType.DECISION);
        fdn4.setSection(Section.DECISION);
        fdn4.setTitle("Test Title4");
        fdn4.setPreamble("Test Preamble4");
        fdn4.setAssistingText("Test assisting text4");
        fdn4.setHasComment(true);
        fdn4.setRowIndex(4L);
        fdn4.setSelectableValues(fieldDefinitionService.getAllSelectableValues().stream().collect(Collectors.toSet()));
        fdn4.setFrontendLocation(FrontendLocation.MAIN_VIEW);

        FieldDefinition fieldDefApplicationQuestion = fieldDefinitionService.createFieldDefinition(fdn1);
        FieldDefinition fieldDefAssessmentQuestion = fieldDefinitionService.createFieldDefinition(fdn2);


        BudgetFieldDefinition budgetFieldDefinition = (BudgetFieldDefinition) fieldDefinitionService.createFieldDefinition(fdn3);
        SelectableFieldDefinition selectableFieldDefinition = (SelectableFieldDefinition) fieldDefinitionService.createFieldDefinition(fdn4);



        return Response.ok().build();
    }
}