package dto.fieldvalue;

import dto.fielddefinition.FieldDefinitionDTO;

import java.util.Set;

public class HistoryLogFieldValueDTO extends AbstractFieldValueDTO<FieldDefinitionDTO> {

    private Set<HistoryEventDTO> historyEvents;

    protected HistoryLogFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition) {
        super(id, owningCaseId, owningFieldDefinition, "historyLogFieldValue");
    }

    public HistoryLogFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, Set<HistoryEventDTO> historyEvents) {
        super(id, owningCaseId, owningFieldDefinition, "historyLogFieldValue");
        this.historyEvents = historyEvents;
    }

    public Set<HistoryEventDTO> getHistoryEvents() {
        return historyEvents;
    }

    public void setHistoryEvents(Set<HistoryEventDTO> historyEvents) {
        this.historyEvents = historyEvents;
    }
}
