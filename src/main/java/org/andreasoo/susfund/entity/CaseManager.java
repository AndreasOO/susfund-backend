package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="case_manager")
public class CaseManager implements Serializable {
    @Id
    private int id;

    private String name;

    public CaseManager() {
    }

    public CaseManager(int id, String name) {
        this.id = id;
        this.name = name;
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

}
