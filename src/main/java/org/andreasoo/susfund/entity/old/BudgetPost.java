package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="budget_post")
public class BudgetPost implements Serializable {
    @Id
    private int id;

    @Column(name="estimated_cost")
    private int estimatedCost;

    @ManyToOne
    @JoinColumn(name="budget_post_type_id")
    private BudgetPostType budgetPostType;


    public BudgetPost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public BudgetPostType getBudgetPostType() {
        return budgetPostType;
    }

    public void setBudgetPostType(BudgetPostType budgetPostType) {
        this.budgetPostType = budgetPostType;
    }
}
