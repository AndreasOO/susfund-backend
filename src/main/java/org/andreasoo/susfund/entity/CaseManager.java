package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="caseManager")
public class CaseManager implements Serializable {
    @Id
    private int id;

    private String name;


//    @OneToMany(mappedBy="caseManager", fetch=FetchType.EAGER)
//    private List<Cases> cases;

    public CaseManager() {
    }

    public CaseManager(int id, String name) {
        this.id = id;
        this.name = name;
//        this.cases = casesManaged;
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

//    public List<Cases> getCases() {
//        return cases;
//    }
//
//    public void setCases(List<Cases> casesManaged) {
//        this.cases = casesManaged;
//    }
}
