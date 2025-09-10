package org.andreasoo.susfund.entity.field.value.history;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.caseentity.CaseEntity;
import org.andreasoo.susfund.entity.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.field.value.AbstractFieldValue;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value="HISTORY_LOG")
public class HistoryLogFieldValue extends AbstractFieldValue<FieldDefinition> {

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="history_log_value_id")
    @OneToMany(mappedBy = "owningHistoryLog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HistoryEvent2>  historyEvents = new HashSet<>();

    public HistoryLogFieldValue() {
        super();
    }

    public HistoryLogFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

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
