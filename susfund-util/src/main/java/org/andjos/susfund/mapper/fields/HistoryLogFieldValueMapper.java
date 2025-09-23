package org.andjos.susfund.mapper.fields;

import org.andjos.susfund.dto.fieldvalue.HistoryEventDTO;
import org.andjos.susfund.dto.fieldvalue.HistoryLogFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.history.HistoryLogFieldValue;

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
