package entity.organization;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(
                name="Organization.findAll",
                query="select o from Organization o"
        )
})
@Table(name="organization")
public class Organization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name="organization_type")
    @Enumerated(EnumType.STRING)
    private OrganizationType organizationType;


    public Organization() {
    }

    public Organization(int id, String name, OrganizationType organizationType) {
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
