package org.andreasoo.susfund.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.andreasoo.susfund.entity.Organization;
import org.andreasoo.susfund.entity.OrganizationType;

import java.util.List;

    @Path("/companies")
public class OrganizationResource {
        @PersistenceContext(unitName = "myUnit")

        private EntityManager entityManager;

    @GET
    @Produces("application/json")
    public List<Organization> getAllOrganizations() {
        return entityManager.createNamedQuery("Organization.findAll", Organization.class).getResultList();
    }
}