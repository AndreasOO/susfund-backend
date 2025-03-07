package org.andreasoo.susfund.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.andreasoo.susfund.entity.Organisation;
import org.andreasoo.susfund.entity.OrganizationType;

import java.util.List;

    @Path("/companies")
public class OrganizationResource {
    @GET
    @Produces("application/json")
    public List<Organisation> getAllOrganizations() {
        return List.of(new Organisation(1, "org1", "55522353", OrganizationType.BRANCH),
                       new Organisation(2, "org2", "55112235", OrganizationType.LIMITED_COMPANY),
                       new Organisation(3, "org3", "55523321", OrganizationType.SOLE_TRADER));
    }
}