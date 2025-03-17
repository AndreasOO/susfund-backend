package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(
                name="Cases.findAll",
                query="select c from Cases c order by c.id"
        )
})
@Table(name="cases")
public class Cases implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name="case_manager_id")
    private CaseManager caseManager;

//    @OneToOne
//    private ApplicationInformation applicationInformation;
//
//    @OneToOne
//    private Budget budget;
//
//    @OneToOne
//    private Assessment assessment;
//
//    @OneToOne
//    private Decision decision;
//
//    @OneToOne
//    private Decision decision;

    public Cases() {
    }

    public Cases(Integer id, String name, Organization organization, CaseManager caseManager) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.caseManager = caseManager;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public CaseManager getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(CaseManager caseManager) {
        this.caseManager = caseManager;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
