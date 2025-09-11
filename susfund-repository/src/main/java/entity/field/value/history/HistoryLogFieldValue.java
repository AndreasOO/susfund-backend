package entity.field.value.history;

import jakarta.persistence.*;
import entity.caseentity.CaseEntity;
import entity.field.definition.FieldDefinition;
import entity.field.value.AbstractFieldValue;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value="HISTORY_LOG")
public class HistoryLogFieldValue extends AbstractFieldValue<FieldDefinition> {

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="history_log_value_id")
    @OneToMany(mappedBy = "owningHistoryLog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HistoryEvent>  historyEvents = new HashSet<>();

    public HistoryLogFieldValue() {
        super();
    }

    public HistoryLogFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

    public Set<HistoryEvent> getHistoryEvents() {
        return historyEvents;
    }

    public void setHistoryEvents(Set<HistoryEvent> historyEvents) {
        this.historyEvents = historyEvents;
    }

    @Override
    public String getValueAsString() {
        return "";
    }
}
