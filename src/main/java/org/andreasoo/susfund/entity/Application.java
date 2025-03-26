package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="application")

public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date submission_date;


    public Application() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }
}
