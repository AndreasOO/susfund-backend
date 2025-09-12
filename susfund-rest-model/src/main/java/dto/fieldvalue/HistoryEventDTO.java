package dto.fieldvalue;

import dto.AbstractDTO;
import org.andjos.susfund.entity.field.value.history.HistoryEventType;

import java.time.LocalDate;

public class HistoryEventDTO extends AbstractDTO {

    private Long id;
    private String historyEventDetails;
    private LocalDate historyEventDate;
    private HistoryEventType historyEventType;

    public HistoryEventDTO(){
        super("historyEventDTO");
    }

    public HistoryEventDTO(Long id, String historyEventDetails, LocalDate historyEventDate, HistoryEventType historyEventType) {
        super("historyEventDTO");
        this.id = id;
        this.historyEventDetails = historyEventDetails;
        this.historyEventDate = historyEventDate;
        this.historyEventType = historyEventType;
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
}
