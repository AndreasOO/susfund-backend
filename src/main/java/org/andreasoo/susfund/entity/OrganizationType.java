package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="organization_type")
public class OrganizationType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public OrganizationType() {
    }

    public OrganizationType(int id, String name) {
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
