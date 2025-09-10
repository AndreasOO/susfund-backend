package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.HistoryEventDTO;
import org.andreasoo.susfund.dto.fieldvalue.HistoryLogFieldValueDTO;
import org.andreasoo.susfund.entity.field.value.history.HistoryLogFieldValue;

import java.util.stream.Collectors;

@ApplicationScoped
public class HistoryLogFieldValueMapper
        implements FieldValueMapper<HistoryLogFieldValue, HistoryLogFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Override
    public HistoryLogFieldValueDTO mapToDTO(HistoryLogFieldValue fieldValue) {
        return new HistoryLogFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getHistoryEvents().stream()
                        .map(he -> new HistoryEventDTO(
                                he.getId(),
                                he.getHistoryEventDetails(),
                                he.getHistoryEventDate(),
                                he.getHistoryEventType()))
                        .collect(Collectors.toSet())
        );
    }
}
