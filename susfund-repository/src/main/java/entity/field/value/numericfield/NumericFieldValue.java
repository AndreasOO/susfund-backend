package entity.field.value.numericfield;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import entity.caseentity.CaseEntity;
import entity.field.definition.FieldDefinition;
import entity.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="NUMERIC")
public class NumericFieldValue extends AbstractFieldValue<FieldDefinition> {

    @Column(name="numeric_value")
    private Integer numericValue;

    public NumericFieldValue() {
        super();
    }

    public NumericFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Integer numericValue) {
        this.numericValue = numericValue;
    }

    @Override
    public String getValueAsString() {
        return "";
    }
}
