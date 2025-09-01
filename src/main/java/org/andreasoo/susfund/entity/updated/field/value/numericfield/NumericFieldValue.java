package org.andreasoo.susfund.entity.updated.field.value.numericfield;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

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
