package org.andreasoo.susfund.entity.old;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="history_event")
public class HistoryEvent implements Serializable {

    @Id
    private int id;

    private String details;

    private LocalDate date;

    public HistoryEvent() {
    }

    @ManyToOne
    @JoinColumn(name="event_type_id")
    private EventType eventType;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
