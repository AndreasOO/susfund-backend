package org.andreasoo.susfund.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="budget_row")
public class BudgetRow {

    @Id
    private Long id;


}
