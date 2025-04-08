package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="case_budget")
public class CaseBudget implements Serializable {
    @Id
    private int id;

    @Column(name="date_last_changed")
    private LocalDate dateLastChanged;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="budget_organization",
            joinColumns = {@JoinColumn(name="case_budget_id")},
            inverseJoinColumns = {@JoinColumn(name="organization_id")}
    )
    private List<Organization> financingOrganizations;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="case_budget_id")
    private List<BudgetPost> budgetPosts;

    public CaseBudget() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateLastChanged() {
        return dateLastChanged;
    }

    public void setDateLastChanged(LocalDate dateLastChanged) {
        this.dateLastChanged = dateLastChanged;
    }

    public List<Organization> getFinancingOrganizations() {
        return financingOrganizations;
    }

    public void setFinancingOrganizations(List<Organization> financingOrganizations) {
        this.financingOrganizations = financingOrganizations;
    }

    public List<BudgetPost> getBudgetPosts() {
        return budgetPosts;
    }

    public void setBudgetPosts(List<BudgetPost> budgetPosts) {
        this.budgetPosts = budgetPosts;
    }
}
