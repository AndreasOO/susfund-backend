package dto;

import org.andjos.susfund.entity.organization.OrganizationType;

public class OrganizationDTO extends AbstractDTO {

    private int id;
    private String name;
    private OrganizationType organizationType;

    public OrganizationDTO() {
        super("organization");

    }

    public OrganizationDTO(int id, String name, OrganizationType organizationType) {
        super("organization");
        this.id = id;
        this.name = name;
        this.organizationType = organizationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }
}
