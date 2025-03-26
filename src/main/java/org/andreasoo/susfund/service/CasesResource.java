package org.andreasoo.susfund.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.andreasoo.susfund.entity.AssessmentItem;
import org.andreasoo.susfund.entity.CaseAssessment;
import org.andreasoo.susfund.entity.Cases;

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
        Cases cases = entityManager.find(Cases.class, id);
        return cases;
    }
}