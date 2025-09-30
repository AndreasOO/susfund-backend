package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.HistoryEventDTO;
import org.andjos.susfund.dto.fieldvalue.HistoryLogFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.history.HistoryEvent;
import org.andjos.susfund.entity.field.value.history.HistoryLogFieldValue;

import java.util.stream.Collectors;

@ApplicationScoped
public class HistoryLogFieldValueMapper
        implements FieldValueMapper<HistoryLogFieldValue, HistoryLogFieldValueDTO>,
                   FieldDefinitionDTOFactory {
    @Inject
    private FieldValueDao fieldValueDao;

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


    @Override
    public HistoryLogFieldValue mapToEntity(HistoryLogFieldValueDTO dto) {
        HistoryLogFieldValue historyLogFieldValue = (HistoryLogFieldValue) fieldValueDao.findById(dto.getId());
        historyLogFieldValue.setHistoryEvents(dto.getHistoryEvents().stream()
                                                                    .map(eventDTO -> new HistoryEvent(
                                                                                                        historyLogFieldValue,
                                                                                                        eventDTO.getHistoryEventDetails(),
                                                                                                        eventDTO.getHistoryEventDate(),
                                                                                                        eventDTO.getHistoryEventType()))
                                                                    .collect(Collectors.toSet()));
        return historyLogFieldValue;
    }
}
