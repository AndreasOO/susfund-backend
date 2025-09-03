package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.mapper.fields.FieldValueMapper;
import org.andreasoo.susfund.mapper.fields.*;
import org.andreasoo.susfund.service.FieldValueMappingService;

import java.util.Map;

@ApplicationScoped
public class FieldValueMappingServiceImpl implements FieldValueMappingService {

    private final Map<FieldType, FieldValueMapper<? extends AbstractFieldValue<?>, ? extends AbstractFieldValueDTO<?>>> mappers;

    @Inject
    public FieldValueMappingServiceImpl(
            TextFieldValueMapper textMapper,
            NumericFieldValueMapper numericMapper,
            DateFieldValueMapper dateMapper,
            DecisionFieldValueMapper decisionMapper,
            BudgetFieldValueMapper budgetMapper,
            AssessmentFieldValueMapper assessmentMapper,
            HistoryLogFieldValueMapper historyLogMapper) {

        this.mappers = Map.of(
                FieldType.TEXT_FIELD, textMapper,
                FieldType.NUMERIC_FIELD, numericMapper,
                FieldType.DATE_FIELD, dateMapper,
                FieldType.DECISION, decisionMapper,
                FieldType.BUDGET, budgetMapper,
                FieldType.APPLICATION_QUESTION, textMapper, // Reuse text mapper
                FieldType.ASSESSMENT_QUESTION, assessmentMapper,
                FieldType.HISTORY_LOG, historyLogMapper
        );
    }

    @Override
    public AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue) {
        FieldValueMapper<AbstractFieldValue<?>, AbstractFieldValueDTO<?>> mapper =
                (FieldValueMapper<AbstractFieldValue<?>, AbstractFieldValueDTO<?>>)
                        mappers.get(fieldValue.getFieldDefinition().getFieldType());

        if (mapper == null) {
            throw new IllegalArgumentException("No mapper found for field type: " + fieldValue.getFieldDefinition().getFieldType());
        }
        return mapper.mapToDTO(fieldValue);
    }
}


