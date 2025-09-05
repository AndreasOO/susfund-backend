package org.andreasoo.susfund.entity.updated.field.value.history;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="history_event2")
public class HistoryEvent2 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO make table
    @Column(name="history_event_details")
    private String historyEventDetails;

    //TODO make table
    @Column(name="history_event_date")
    private LocalDate historyEventDate;

    //TODO make table
    @Column(name="history_event_type")
    @Enumerated(EnumType.STRING)
    private HistoryEventType historyEventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_value_entity_id", nullable = false)
    private HistoryLogFieldValue owningHistoryLog;

    public HistoryEvent2(){

    }

    public HistoryEvent2(HistoryLogFieldValue owningHistoryLog, String historyEventDetails, LocalDate historyEventDate, HistoryEventType historyEventType) {
        this.historyEventDetails = historyEventDetails;
        this.historyEventDate = historyEventDate;
        this.historyEventType = historyEventType;
        this.owningHistoryLog = owningHistoryLog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistoryEventDetails() {
        return historyEventDetails;
    }

    public void setHistoryEventDetails(String historyEventDetails) {
        this.historyEventDetails = historyEventDetails;
    }

    public LocalDate getHistoryEventDate() {
        return historyEventDate;
    }

    public void setHistoryEventDate(LocalDate historyEventDate) {
        this.historyEventDate = historyEventDate;
    }

    public HistoryEventType getHistoryEventType() {
        return historyEventType;
    }

    public void setHistoryEventType(HistoryEventType historyEventType) {
        this.historyEventType = historyEventType;
    }

    public HistoryLogFieldValue getOwningHistoryLog() {
        return owningHistoryLog;
    }

    public void setOwningHistoryLog(HistoryLogFieldValue owningHistoryLog) {
        this.owningHistoryLog = owningHistoryLog;
    }
}
