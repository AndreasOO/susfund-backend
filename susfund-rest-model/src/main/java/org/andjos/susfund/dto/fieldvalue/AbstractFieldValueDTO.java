package org.andjos.susfund.dto.fieldvalue;

//import org.andjos.susfund.dto.AbstractDTO;
import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import jakarta.json.bind.annotation.JsonbSubtype;
import jakarta.json.bind.annotation.JsonbTypeInfo;


@JsonbTypeInfo(
        key = "dtoClass",
        value = {
                @JsonbSubtype(alias = "textFieldValue", type = TextFieldValueDTO.class),
                @JsonbSubtype(alias = "assessmentFieldValue", type = AssessmentFieldValueDTO.class),
                @JsonbSubtype(alias = "budgetFieldValue", type = BudgetFieldValueDTO.class),
                @JsonbSubtype(alias = "dateFieldValue", type = DateFieldValueDTO.class),
                @JsonbSubtype(alias = "HistoryLogFieldValue", type = HistoryLogFieldValueDTO.class),
                @JsonbSubtype(alias = "decisionFieldValue", type = DecisionFieldValueDTO.class),
                @JsonbSubtype(alias = "numericFieldValue", type = NumericFieldValueDTO.class)
        }
)
public abstract class AbstractFieldValueDTO<T extends FieldDefinitionDTO> {

    public Long id;
    public Long owningCaseId;
    public FieldDefinitionDTO owningFieldDefinition;


    public AbstractFieldValueDTO() {
    }

//    public AbstractFieldValueDTO() {
//        super();
//    }

//    public AbstractFieldValueDTO(String dtoClass) {
//        super(dtoClass);
//    }

    protected AbstractFieldValueDTO(Long id, Long owningCaseId, FieldDefinitionDTO owningFieldDefinition, String dtoClassName) {
//        super(dtoClassName);
        this.id = id;
        this.owningCaseId = owningCaseId;
        this.owningFieldDefinition = owningFieldDefinition;
    }

    public Long getOwningCaseId() {
        return owningCaseId;
    }

    public FieldDefinitionDTO getOwningFieldDefinition() {
        return owningFieldDefinition;
    }

    public Long getId() {
        return id;
    }
}
