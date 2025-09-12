package org.andreasoo.susfund.controller.resources;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.andjos.susfund.entity.organization.Organization;
import org.andjos.susfund.service.OrganizationService;

import java.util.List;

@Stateless
@Path("/companies")
public class OrganizationResource {

        @Inject
        private OrganizationService organizationService;

        @GET
        @Produces("application/json")
        public List<Organization> getAllOrganizations() {
            return organizationService.getAllOrganizations();
        }
}