package mapper.fields;

import dto.fieldvalue.HistoryEventDTO;
import dto.fieldvalue.HistoryLogFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import entity.field.value.history.HistoryLogFieldValue;

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
