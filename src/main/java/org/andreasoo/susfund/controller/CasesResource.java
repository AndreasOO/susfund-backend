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
import org.andreasoo.susfund.entity.old.*;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.field.definition.*;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.service.*;


import java.util.Collections;
import java.util.List;


@Stateless
@Path("/cases")
public class CasesResource {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    private CaseEntityService caseEntityService;

    @Inject
    private BudgetService budgetService;

    @Inject
    private FieldDefinitionService fieldDefinitionService;

    @Inject
    private SupportTypeNodeService supportTypeNodeService;

    @Inject
    private GeneralMappingService generalMappingService;

    @Inject
    private FieldValueMappingService fieldValueMappingService;


    @GET
    @Produces("application/json")
    public List<CaseEntity> getAllCases() {
        return caseEntityService.getAllCaseEntities();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public CaseDTO getCaseById(@PathParam("id") Long id) {
//        System.out.println(budgetService.test(id));
        return generalMappingService.mapToDTO(caseEntityService.getCaseEntityById(id));
    }

    // Flytta till organization resource?
    @Path("/{id}/organization")
    @GET()
    @Produces("application/json")
    public Organization getOrganizationByCaseId(@PathParam("id") int id) {
        return caseEntityService.getOrganizationByCaseId(id);
    }

    @Path("/{id}/casemanager")
    @GET()
    @Produces("application/json")
    public CaseManager getCaseManagerByCaseId(@PathParam("id") int id) {
        return caseEntityService.getCaseManagerByCaseId(id);
    }

    @Path("/casemanagers")
    @GET()
    @Produces("application/json")
    public List<CaseManager> getCaseManagers() {
        return caseEntityService.getCaseManagers();
    }


    @Path("/fields")
    @GET()
    @Produces("application/json")
    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitionService.getAllFieldDefinitions();
    }

    @Path("/getsimplecase")
    @GET()
    @Produces("application/json")
    public Response getSimpleCase() {
        CaseEntity caze = caseEntityService.getCaseEntityById(1L);
        SimpleCaseDTO simpleCase = new SimpleCaseDTO(caze.getId(), caze.getName(), caze.getOrganization().getName(), caze.getCaseManager().getName(), caze.getCaseController().getName(), caze.getCaseStatus(), caze.getCaseDecisionType());
        return Response.ok(simpleCase).build();
    }

    @Path("/get-case-entity")
    @GET()
    @Produces("application/json")
    public Response getCaseEntity() {
        CaseEntity caze = caseEntityService.getCaseEntityById(1L);
        return Response.ok(generalMappingService.mapToDTO(caze)).build();
    }


    @Path("/{id}/assessment-fields")
    @GET()
    @Produces("application/json")
    public Response getAssessmentFields(@PathParam("id") Long id){
        CaseEntity caseEntity = caseEntityService.getCaseEntityById(id);
        List<AbstractFieldValue<? extends FieldDefinition>> assessmentValues = caseEntity.getFieldValues().stream().filter(fieldValue -> fieldValue.getFieldDefinition().getFieldType() == FieldType.ASSESSMENT_QUESTION).toList();
        return Response.ok(assessmentValues.stream().map(value -> fieldValueMappingService.mapFieldValueToDTO(value)).toList()).build();
    }


    @Path("/{id}/application-fields")
    @GET()
    @Produces("application/json")
    public Response getApplicationFields(@PathParam("id") Long id){
        CaseEntity caseEntity = caseEntityService.getCaseEntityById(id);
        List<AbstractFieldValue<? extends FieldDefinition>> applicationValues = caseEntity.getFieldValues().stream().filter(fieldValue -> fieldValue.getFieldDefinition().getFieldType() == FieldType.APPLICATION_QUESTION).toList();
        return Response.ok(applicationValues.stream().map(value -> fieldValueMappingService.mapFieldValueToDTO(value)).toList()).build();
    }

    @Path("/{id}/organization")
    @GET()
    @Produces("application/json")
    public Response getOrganization(@PathParam("id") Long id){
        CaseEntity caseEntity = caseEntityService.getCaseEntityById(id);
        return Response.ok(generalMappingService.mapToDTO(caseEntity.getOrganization())).build();
    }

    @Path("/{id}/decision-field")
    @GET()
    @Produces("application/json")
    public Response getDecisionFields(@PathParam("id") Long id){
        CaseEntity caseEntity = caseEntityService.getCaseEntityById(id);
        List<AbstractFieldValue<? extends FieldDefinition>> decisionFieldValues = caseEntity.getFieldValues().stream().filter(fieldValue -> fieldValue.getFieldDefinition().getFieldType() == FieldType.DECISION).toList();
        return Response.ok(decisionFieldValues.stream().map(value -> fieldValueMappingService.mapFieldValueToDTO(value)).toList()).build();
    }

    @Path("/{id}/budget-field")
    @GET()
    @Produces("application/json")
    public Response getBudgetFields(@PathParam("id") Long id){
        CaseEntity caseEntity = caseEntityService.getCaseEntityById(id);
        List<AbstractFieldValue<? extends FieldDefinition>> budgetFieldValues = caseEntity.getFieldValues().stream().filter(fieldValue -> fieldValue.getFieldDefinition().getFieldType() == FieldType.BUDGET).toList();
        return Response.ok(budgetFieldValues.stream().map(value -> fieldValueMappingService.mapFieldValueToDTO(value)).toList()).build();
    }

    @Path("/{id}/history-field")
    @GET()
    @Produces("application/json")
    public Response getHistoryFields(@PathParam("id") Long id){
        CaseEntity caseEntity = caseEntityService.getCaseEntityById(id);
        List<AbstractFieldValue<? extends FieldDefinition>> historyFields = caseEntity.getFieldValues().stream().filter(fieldValue -> fieldValue.getFieldDefinition().getFieldType() == FieldType.HISTORY_LOG).toList();
        return Response.ok(historyFields.stream().map(value -> fieldValueMappingService.mapFieldValueToDTO(value)).toList()).build();
    }

    @Path("/simple")
    @GET()
    @Produces("application/json")
    public Response getAllCaseEntitiesSimple(){
        return Response.ok(caseEntityService.getAllCaseEntities().stream().map(caseEntity -> generalMappingService.mapCaseToSimpleCaseDTO(caseEntity)).toList()).build();
    }

}