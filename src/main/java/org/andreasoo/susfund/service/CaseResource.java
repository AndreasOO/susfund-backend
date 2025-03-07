package org.andreasoo.susfund.service;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.andreasoo.susfund.entity.Case;

import javax.sql.DataSource;
import java.util.List;



@Path("/cases")
public class CaseResource {

    @PersistenceContext(unitName = "myUnit")
    private EntityManager entityManager;

    @GET
    @Produces("application/json")
    public List<Case> getAllCases() {
        return List.of(new Case(1, "test"),
                       new Case(2, "one"),
                       new Case(3, "two"));
    }
}