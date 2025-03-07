package org.andreasoo.susfund.entity;

public class Organisation {
    private int id;
    private String name;
    private String organizationNumber;
    private OrganizationType organizationType;


    public Organisation(int id, String name, String organizationNumber, OrganizationType organizationType) {
        this.id = id;
        this.name = name;
        this.organizationNumber = organizationNumber;
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

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }
}
