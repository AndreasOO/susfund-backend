package org.andreasoo.susfund.dto.fieldvalue;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.history.HistoryEvent2;

import java.util.Set;

public class HistoryLogFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Set<HistoryEventDTO> historyEvents;

    protected HistoryLogFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(owningCaseId, owningFieldDefinition, "historyLogFieldValue");
    }

    public HistoryLogFieldValueDTO(Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Set<HistoryEventDTO> historyEvents) {
        super(owningCaseId, owningFieldDefinition, "historyLogFieldValue");
        this.historyEvents = historyEvents;
    }

    public Set<HistoryEventDTO> getHistoryEvents() {
        return historyEvents;
    }

    public void setHistoryEvents(Set<HistoryEventDTO> historyEvents) {
        this.historyEvents = historyEvents;
    }
}
