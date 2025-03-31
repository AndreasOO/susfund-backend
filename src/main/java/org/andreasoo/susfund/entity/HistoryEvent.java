package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="history_event")
public class HistoryEvent implements Serializable {

    @Id
    private int id;

    private String details;

    //private Date date;

    public HistoryEvent() {
    }

    @ManyToOne
    @JoinColumn(name="event_type_id")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name="cases_id")
    private Cases cases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Cases getCases() {
        return cases;
    }

    public void setCases(Cases cases) {
        this.cases = cases;
    }
}
