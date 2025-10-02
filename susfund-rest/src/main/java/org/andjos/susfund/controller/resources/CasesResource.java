package org.andjos.susfund.controller.resources;


import jakarta.ws.rs.*;
import org.andjos.susfund.dto.CaseDTO;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.casemanager.CaseManager;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.definition.fieldtype.FieldType;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import org.andjos.susfund.entity.organization.Organization;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import org.andjos.susfund.service.FieldDefinitionService;
import org.andjos.susfund.mapperservice.FieldValueMappingService;
import org.andjos.susfund.mapperservice.GeneralMappingService;
import org.andjos.susfund.service.SupportTypeNodeService;
import org.andjos.susfund.service.CaseEntityService;
import org.andjos.susfund.statemachine.state.DecisionRoundState;


import java.util.List;


@Stateless
@Path("/cases")
public class CasesResource {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    private CaseEntityService caseEntityService;

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

//    @Path("/getsimplecase")
//    @GET()
//    @Produces("application/json")
//    public Response getSimpleCase() {
//        CaseEntity caze = caseEntityService.getCaseEntityById(1L);
//        SimpleCaseDTO simpleCase = new SimpleCaseDTO(caze.getId(), caze.getName(), caze.getOrganization().getName(), caze.getCaseManager().getName(), caze.getCaseController().getName(), caze.getCaseStatus(), caze.getCaseDecisionType());
//        return Response.ok(simpleCase).build();
//    }

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

    @Path("/{id}/savefields")
    @POST()
    @Consumes("application/json")
    @Produces("application/json")
    public Response saveFields(@PathParam("id") Long id, List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> dtos) {
        try {
            System.out.println("hit savefields endpoint endpoint");
            caseEntityService.saveFields(id, dtos);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/{id}/decisionroundstatetransition")
    @GET()
    @Produces("application/json")
    public Response decisionRoundStateTransition(@PathParam("id") Long id){
        try{
            System.out.println("hit decision round state transition endpoint");
            caseEntityService.updateCaseDecisionRoundState(id);
            CaseEntity updatedCase = caseEntityService.getCaseEntityById(id);
            DecisionRoundState newDecisionRoundState = new DecisionRoundState(updatedCase.getCaseDecisionType(), updatedCase.getCaseStatus());
            return Response.ok(newDecisionRoundState).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}