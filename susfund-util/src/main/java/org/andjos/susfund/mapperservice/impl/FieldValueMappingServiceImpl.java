package org.andjos.susfund.mapperservice.impl;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.mapper.fields.*;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import org.andjos.susfund.entity.field.value.assessment.AssessmentFieldValue;
import org.andjos.susfund.entity.field.value.budget.BudgetFieldValue;
import org.andjos.susfund.entity.field.value.datefield.DateFieldValue;
import org.andjos.susfund.entity.field.value.decision.DecisionFieldValue;
import org.andjos.susfund.entity.field.value.history.HistoryLogFieldValue;
import org.andjos.susfund.entity.field.value.numericfield.NumericFieldValue;
import org.andjos.susfund.entity.field.value.textfield.TextFieldValue;
import org.andjos.susfund.mapperservice.FieldValueMappingService;

import java.util.Map;

@ApplicationScoped
public class FieldValueMappingServiceImpl implements FieldValueMappingService {

    private final Map<Class<?>, FieldValueMapper<?, ?>> mappers;

    @Inject
    public FieldValueMappingServiceImpl(
            TextFieldValueMapper textMapper,
            NumericFieldValueMapper numericMapper,
            DateFieldValueMapper dateMapper,
            DecisionFieldValueMapper decisionMapper,
            BudgetFieldValueMapper budgetMapper,
            AssessmentFieldValueMapper assessmentMapper,
            HistoryLogFieldValueMapper historyLogMapper) {

        this.mappers = Map.ofEntries(
                Map.entry(TextFieldValue.class, textMapper),
                Map.entry(NumericFieldValue.class, numericMapper),
                Map.entry(DateFieldValue.class, dateMapper),
                Map.entry(DecisionFieldValue.class, decisionMapper),
                Map.entry(BudgetFieldValue.class, budgetMapper),
                Map.entry(AssessmentFieldValue.class, assessmentMapper),
                Map.entry(HistoryLogFieldValue.class, historyLogMapper),
                Map.entry(TextFieldValueDTO.class, textMapper),
                Map.entry(NumericFieldValueDTO.class, numericMapper),
                Map.entry(DateFieldValueDTO.class, dateMapper),
                Map.entry(DecisionFieldValueDTO.class, decisionMapper),
                Map.entry(BudgetFieldValueDTO.class, budgetMapper),
                Map.entry(AssessmentFieldValueDTO.class, assessmentMapper),
                Map.entry(HistoryLogFieldValueDTO.class, historyLogMapper)
        );
    }

    @Override
    public AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue) {
        return getMapper(fieldValue.getClass())
                .mapToDTO(fieldValue);
    }

    @Override
    public AbstractFieldValue<? extends FieldDefinition> mapDTOToFieldValue(AbstractFieldValueDTO<? extends FieldDefinitionDTO> fieldValueDTO) {
        return getMapper(fieldValueDTO.getClass())
                .mapToEntity(fieldValueDTO);
    }


    @SuppressWarnings("unchecked")
    private <T extends AbstractFieldValue<?>> FieldValueMapper<T, AbstractFieldValueDTO<?>> getMapper(Class<?> fieldValueType) {
        FieldValueMapper<?, ?> mapper = mappers.get(fieldValueType);

        if (mapper == null) {
            throw new IllegalArgumentException("No mapper found for field value type: " + fieldValueType.getSimpleName());
        }

        return (FieldValueMapper<T, AbstractFieldValueDTO<?>>) mapper;
    }
}


