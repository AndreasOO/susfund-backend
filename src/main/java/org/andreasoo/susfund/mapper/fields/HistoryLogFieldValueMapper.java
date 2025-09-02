package org.andreasoo.susfund.mapper.fields;

import jakarta.enterprise.context.ApplicationScoped;
import org.andreasoo.susfund.dto.fieldvalue.HistoryEventDTO;
import org.andreasoo.susfund.dto.fieldvalue.HistoryLogFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.history.HistoryLogFieldValue;
import org.andreasoo.susfund.mapper.FieldValueMapper;

import java.util.stream.Collectors;

@ApplicationScoped
public class HistoryLogFieldValueMapper extends BaseFieldValueMapper
        implements FieldValueMapper<HistoryLogFieldValue, HistoryLogFieldValueDTO> {

    @Override
    public HistoryLogFieldValueDTO mapToDTO(HistoryLogFieldValue fieldValue, Long caseId) {
        return new HistoryLogFieldValueDTO(
                caseId,
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
