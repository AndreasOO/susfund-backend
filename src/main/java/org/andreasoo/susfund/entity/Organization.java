package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name="Organization.findAll",
                query="select o from Organization o"
        )
})
@Table(name="organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private OrganizationType organizationType;


    public Organization() {
    }

    public Organization(int id, String name, String organizationNumber, OrganizationType organizationType) {
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
