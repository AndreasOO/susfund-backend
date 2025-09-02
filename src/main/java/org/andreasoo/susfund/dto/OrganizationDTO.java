package org.andreasoo.susfund.dto;

public class OrganizationDTO extends AbstractDTO {

    private int id;
    private String name;
    private String organizationType;

    public OrganizationDTO() {
        super("organization");

    }

    public OrganizationDTO(int id, String name, String organizationType) {
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

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }
}
