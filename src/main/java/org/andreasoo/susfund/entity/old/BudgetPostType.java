package org.andreasoo.susfund.entity.old;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="budget_post_type")
public class BudgetPostType implements Serializable {
    @Id
    private int id;

    private String name;


    public BudgetPostType() {
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
