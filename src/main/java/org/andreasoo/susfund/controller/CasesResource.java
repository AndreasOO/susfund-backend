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
import org.andreasoo.susfund.dto.*;
import org.andreasoo.susfund.dto.fielddefinition.BudgetFieldDefinitionDTO;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fielddefinition.SelectableFieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.*;
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.field.definition.*;
import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetType;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.definition.location.FrontendLocation;
import org.andreasoo.susfund.entity.updated.field.definition.section.Section;
import org.andreasoo.susfund.entity.updated.field.definition.selectable.SelectableFieldDefinition;
import org.andreasoo.susfund.entity.updated.field.definition.section.Section;
import org.andreasoo.susfund.entity.updated.field.definition.section.SubSection;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.assessment.AssessmentFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.budget.BudgetFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.datefield.DateFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.decision.DecisionFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.history.HistoryLogFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.numericfield.NumericFieldValue;
import org.andreasoo.susfund.entity.updated.field.value.textfield.TextFieldValue;
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode;
import org.andreasoo.susfund.service.*;
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

    @Inject
    private SupportTypeNodeService supportTypeNodeService;

    @Inject
    private GeneralMappingService generalMappingService;

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

    @Path("/createcase")
    @GET()
    @Produces("application/json")
    public Response createCaseWithFieldValues() {
        CaseEntity caze = casesService.createCaseWithMockData();

        CaseDTO caseDTO = new CaseDTO(
                caze.getId(),
                caze.getName(),
                new OrganizationDTO(caze.getOrganization().getId(), caze.getOrganization().getName(), caze.getOrganization().getOrganizationType().getName()),
                new CaseManagerDTO(caze.getCaseManager().getId(), caze.getCaseManager().getName()),
                new CaseManagerDTO(caze.getCaseController().getId(), caze.getCaseController().getName()),
                new CaseManagerDTO(caze.getHandledBy().getId(), caze.getHandledBy().getName()),
                caze.getCaseStatus(),
                caze.getCaseDecisionType(),
                new SupportTypeNodeDTO(caze.getSupportTypeNode().getId(), caze.getSupportTypeNode().getTechName()),
                caze.getFieldValues().stream().<AbstractFieldValueDTO<? extends FieldDefinitionDTO>>map(fve -> {
                     switch (fve.getFieldDefinition().getFieldType()) {
                        case TEXT_FIELD -> {
                            TextFieldValue tFve = (TextFieldValue) fve;
                            return new TextFieldValueDTO(
                                    caze.getId(),
                                    new FieldDefinitionDTO(
                                            tFve.getFieldDefinition().getId(),
                                            tFve.getFieldDefinition().getTitle(),
                                            tFve.getFieldDefinition().getPreamble(),
                                            tFve.getFieldDefinition().getAssistingText(),
                                            tFve.getFieldDefinition().isHasComment(),
                                            tFve.getFieldDefinition().getSection(),
                                            tFve.getFieldDefinition().getSubSection(),
                                            tFve.getFieldDefinition().getFieldType(),
                                            tFve.getFieldDefinition().getFrontendLocation(),
                                            tFve.getFieldDefinition().getRowIndex()),
                                    tFve.getStringValue());
                        }
                        case NUMERIC_FIELD -> {
                            NumericFieldValue nFve = (NumericFieldValue) fve;
                            return new NumericFieldValueDTO(
                                    caze.getId(),
                                    new FieldDefinitionDTO(
                                            nFve.getFieldDefinition().getId(),
                                            nFve.getFieldDefinition().getTitle(),
                                            nFve.getFieldDefinition().getPreamble(),
                                            nFve.getFieldDefinition().getAssistingText(),
                                            nFve.getFieldDefinition().isHasComment(),
                                            nFve.getFieldDefinition().getSection(),
                                            nFve.getFieldDefinition().getSubSection(),
                                            nFve.getFieldDefinition().getFieldType(),
                                            nFve.getFieldDefinition().getFrontendLocation(),
                                            nFve.getFieldDefinition().getRowIndex()),
                                    nFve.getNumericValue());
                        }
                        case DATE_FIELD -> {
                            DateFieldValue dFve = (DateFieldValue) fve;
                            return new DateFieldValueDTO(
                                    caze.getId(),
                                    new FieldDefinitionDTO(
                                            dFve.getFieldDefinition().getId(),
                                            dFve.getFieldDefinition().getTitle(),
                                            dFve.getFieldDefinition().getPreamble(),
                                            dFve.getFieldDefinition().getAssistingText(),
                                            dFve.getFieldDefinition().isHasComment(),
                                            dFve.getFieldDefinition().getSection(),
                                            dFve.getFieldDefinition().getSubSection(),
                                            dFve.getFieldDefinition().getFieldType(),
                                            dFve.getFieldDefinition().getFrontendLocation(),
                                            dFve.getFieldDefinition().getRowIndex()),
                                    dFve.getDateValue());
                        }
                        case DECISION -> {
                            DecisionFieldValue dFve = (DecisionFieldValue) fve;
                            return new DecisionFieldValueDTO(
                                    caze.getId(),
                                    new SelectableFieldDefinitionDTO(
                                            dFve.getFieldDefinition().getId(),
                                            dFve.getFieldDefinition().getTitle(),
                                            dFve.getFieldDefinition().getPreamble(),
                                            dFve.getFieldDefinition().getAssistingText(),
                                            dFve.getFieldDefinition().isHasComment(),
                                            dFve.getFieldDefinition().getSection(),
                                            dFve.getFieldDefinition().getSubSection(),
                                            dFve.getFieldDefinition().getFieldType(),
                                            dFve.getFieldDefinition().getFrontendLocation(),
                                            dFve.getFieldDefinition().getRowIndex(),
                                            dFve.getFieldDefinition().getSelectableValues().stream().map(
                                                                                            slv -> new SelectableValueDTO(slv.getId(),
                                                                                                         slv.getValue(),
                                                                                                         slv.getSelectableType()))
                                                                                            .collect(Collectors.toSet())),
                                    dFve.getDecisionResultType());
                        }
                        case BUDGET -> {
                            BudgetFieldValue bFve = (BudgetFieldValue) fve;
                            return new BudgetFieldValueDTO(
                                    caze.getId(),
                                    new BudgetFieldDefinitionDTO(
                                            bFve.getFieldDefinition().getId(),
                                            bFve.getFieldDefinition().getTitle(),
                                            bFve.getFieldDefinition().getPreamble(),
                                            bFve.getFieldDefinition().getAssistingText(),
                                            bFve.getFieldDefinition().isHasComment(),
                                            bFve.getFieldDefinition().getSection(),
                                            bFve.getFieldDefinition().getSubSection(),
                                            bFve.getFieldDefinition().getFieldType(),
                                            bFve.getFieldDefinition().getFrontendLocation(),
                                            bFve.getFieldDefinition().getRowIndex(),
                                            bFve.getFieldDefinition().getBudgetType()),
                                            bFve.getTotalFinancingRatio(),
                                            bFve.getFinancingRows().stream()
                                                                   .map(row -> new FinancingRowDTO(
                                                                                                row.getId(),
                                                                                                new OrganizationDTO(row.getOrganization().getId(),
                                                                                                                    row.getOrganization().getName(),
                                                                                                                    row.getOrganization().getOrganizationType().getName()),
                                                                                                row.getFinancingAmount(),
                                                                                                row.getFinancingPercentage()))
                                                                   .toList(),
                                            bFve.getBudgetRows().stream()
                                                                .map(row -> new BudgetRowDTO(
                                                                        row.getId(),
                                                                        row.getEstimatedCost(),
                                                                        row.getCostType(),
                                                                        row.getAccruedCost()))
                                                               .toList()
                                            );
                        }
                        case APPLICATION_QUESTION -> {
                            TextFieldValue apqFve = (TextFieldValue) fve;
                            return new TextFieldValueDTO(
                                    caze.getId(),
                                    new FieldDefinitionDTO(
                                            apqFve.getFieldDefinition().getId(),
                                            apqFve.getFieldDefinition().getTitle(),
                                            apqFve.getFieldDefinition().getPreamble(),
                                            apqFve.getFieldDefinition().getAssistingText(),
                                            apqFve.getFieldDefinition().isHasComment(),
                                            apqFve.getFieldDefinition().getSection(),
                                            apqFve.getFieldDefinition().getSubSection(),
                                            apqFve.getFieldDefinition().getFieldType(),
                                            apqFve.getFieldDefinition().getFrontendLocation(),
                                            apqFve.getFieldDefinition().getRowIndex()),
                                    apqFve.getStringValue());
                        }
                        case ASSESSMENT_QUESTION -> {
                            AssessmentFieldValue asqFve = (AssessmentFieldValue) fve;
                            return new AssessmentFieldValueDTO(
                                    caze.getId(),
                                    new FieldDefinitionDTO(
                                            asqFve.getFieldDefinition().getId(),
                                            asqFve.getFieldDefinition().getTitle(),
                                            asqFve.getFieldDefinition().getPreamble(),
                                            asqFve.getFieldDefinition().getAssistingText(),
                                            asqFve.getFieldDefinition().isHasComment(),
                                            asqFve.getFieldDefinition().getSection(),
                                            asqFve.getFieldDefinition().getSubSection(),
                                            asqFve.getFieldDefinition().getFieldType(),
                                            asqFve.getFieldDefinition().getFrontendLocation(),
                                            asqFve.getFieldDefinition().getRowIndex()),
                                    asqFve.getAssessmentScore(),
                                    asqFve.getAssessmentJustification());
                        }
                        case HISTORY_LOG -> {
                            HistoryLogFieldValue dFve = (HistoryLogFieldValue) fve;
                            return new HistoryLogFieldValueDTO(
                                    caze.getId(),
                                    new FieldDefinitionDTO(
                                            dFve.getFieldDefinition().getId(),
                                            dFve.getFieldDefinition().getTitle(),
                                            dFve.getFieldDefinition().getPreamble(),
                                            dFve.getFieldDefinition().getAssistingText(),
                                            dFve.getFieldDefinition().isHasComment(),
                                            dFve.getFieldDefinition().getSection(),
                                            dFve.getFieldDefinition().getSubSection(),
                                            dFve.getFieldDefinition().getFieldType(),
                                            dFve.getFieldDefinition().getFrontendLocation(),
                                            dFve.getFieldDefinition().getRowIndex()),
                                    dFve.getHistoryEvents().stream().map(he -> new HistoryEventDTO(
                                                                                     he.getId(),
                                                                                     he.getHistoryEventDetails(),
                                                                                     he.getHistoryEventDate(),
                                                                                     he.getHistoryEventType()))
                                            .collect(Collectors.toSet()));
                        }
                        default -> throw new RuntimeException("oops");
                    }
                }).toList()
        );
        return Response.ok(generalMappingService.mapToDTO(caze)).build();
//        return Response.ok(generalMappingService.mapCaseToDTO(caze)).build();
//        return Response.ok(caseDTO).build();
    }

    @Path("/createfields")
    @GET()
    @Produces("application/json")
    public Response createFieldDefinition() {

        SupportTypeNode stn = new SupportTypeNode();
        stn.setTechName("FTG:/2022:/REGIONAL_INVESTMENT:/INFRASTRUCTURE");
        SupportTypeNode savedSupportTypeNode = supportTypeNodeService.saveSupportTypeNode(stn);

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


        FieldDefinition fdn5 = new FieldDefinition();
        fdn5.setFieldType(FieldType.NUMERIC_FIELD);
        fdn5.setSection(Section.DECISION);
        fdn5.setRowIndex(2L);
        fdn5.setFrontendLocation(FrontendLocation.MAIN_VIEW);

        FieldDefinition fdn6 = new FieldDefinition();
        fdn6.setFieldType(FieldType.DATE_FIELD);
        fdn6.setSection(Section.DECISION);
        fdn6.setRowIndex(1L);
        fdn6.setFrontendLocation(FrontendLocation.MAIN_VIEW);



        FieldDefinition fieldDefApplicationQuestion = fieldDefinitionService.createFieldDefinition(fdn1);
        FieldDefinition fieldDefAssessmentQuestion = fieldDefinitionService.createFieldDefinition(fdn2);


        BudgetFieldDefinition budgetFieldDefinition = (BudgetFieldDefinition) fieldDefinitionService.createFieldDefinition(fdn3);
        SelectableFieldDefinition selectableFieldDefinition = (SelectableFieldDefinition) fieldDefinitionService.createFieldDefinition(fdn4);

        FieldDefinition numericFieldDefinition = fieldDefinitionService.createFieldDefinition(fdn5);
        FieldDefinition dateFieldDefinition = fieldDefinitionService.createFieldDefinition(fdn6);

        savedSupportTypeNode.getFieldDefinitions().addAll(fieldDefinitionService.getAllFieldDefinitions());
        supportTypeNodeService.saveSupportTypeNode(savedSupportTypeNode);

        return Response.ok().build();
    }



    @Path("/getsimplecase")
    @GET()
    @Produces("application/json")
    public Response getSimpleCase() {
        CaseEntity caze = casesService.createCaseWithMockData();

        SimpleCaseDTO simpleCase = new SimpleCaseDTO(caze.getId(), caze.getName(), caze.getOrganization().getName(), caze.getCaseManager().getName(), caze.getCaseController().getName(), caze.getCaseStatus(), caze.getCaseDecisionType());

        return Response.ok(simpleCase).build();
    }

}