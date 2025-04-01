package org.andreasoo.susfund.service;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.andreasoo.susfund.dao.CaseApplicationDao;
import org.andreasoo.susfund.dao.CaseAssessmentDao;
import org.andreasoo.susfund.dao.CasesDao;
import org.andreasoo.susfund.dao.CasesDaoImpl;
import org.andreasoo.susfund.entity.AssessmentResult;
import org.andreasoo.susfund.entity.Cases;
import org.andreasoo.susfund.util.ApplicationUtil;
import org.andreasoo.susfund.util.AssessmentUtil;

import java.util.List;



@Path("/cases")
public class CasesResource {

    @Inject
    private CasesDao casesDao;

    @Inject
    private CaseAssessmentDao caseAssessmentDao;

    @Inject
    private CaseApplicationDao caseApplicationDao;

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

    @Path("/{id}/application")
    @GET()
    @Produces("application/json")
    public ApplicationUtil getApplicationUtilByCaseId(@PathParam("id") int id) {
        return caseApplicationDao.getApplicationUtilByCaseId(id);
    }
}