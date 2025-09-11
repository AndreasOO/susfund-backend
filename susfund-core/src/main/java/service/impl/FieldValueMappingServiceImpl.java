package service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import entity.field.value.AbstractFieldValue;
import entity.field.value.assessment.AssessmentFieldValue;
import entity.field.value.budget.BudgetFieldValue;
import entity.field.value.datefield.DateFieldValue;
import entity.field.value.decision.DecisionFieldValue;
import entity.field.value.history.HistoryLogFieldValue;
import entity.field.value.numericfield.NumericFieldValue;
import entity.field.value.textfield.TextFieldValue;
import org.andreasoo.susfund.mapper.fields.FieldValueMapper;
import service.FieldValueMappingService;

import java.util.Map;

@ApplicationScoped
public class FieldValueMappingServiceImpl implements FieldValueMappingService {

    private final Map<Class<? extends AbstractFieldValue<?>>, FieldValueMapper<?, ?>> mappers;

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
                TextFieldValue.class, textMapper,
                NumericFieldValue.class, numericMapper,
                DateFieldValue.class, dateMapper,
                DecisionFieldValue.class, decisionMapper,
                BudgetFieldValue.class, budgetMapper,
                AssessmentFieldValue.class, assessmentMapper,
                HistoryLogFieldValue.class, historyLogMapper
        );
    }

    @Override
    public AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue) {
        return getMapper(fieldValue.getClass())
                .mapToDTO(fieldValue);
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


