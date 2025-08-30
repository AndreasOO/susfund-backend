package org.andreasoo.susfund.entity.updated.field.value.history;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

import java.util.Set;

@Entity
@DiscriminatorValue(value="HISTORY_LOG")
public class HistoryLogFieldValue extends AbstractFieldValue<FieldDefinition> {


    public HistoryLogFieldValue() {
        super();
    }

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="history_log_value_id")
    private Set<HistoryEvent2>  historyEvents;


    public Set<HistoryEvent2> getHistoryEvents() {
        return historyEvents;
    }

    public void setHistoryEvents(Set<HistoryEvent2> historyEvents) {
        this.historyEvents = historyEvents;
    }

    @Override
    public String getValueAsString() {
        return "";
    }
}
