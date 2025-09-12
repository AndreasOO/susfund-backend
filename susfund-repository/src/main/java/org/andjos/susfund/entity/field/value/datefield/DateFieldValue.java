package org.andjos.susfund.entity.field.value.datefield;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

import java.time.LocalDate;

@Entity
@DiscriminatorValue(value="DATE")
public class DateFieldValue extends AbstractFieldValue<FieldDefinition>  {

    @Column(name="date_value")
    private LocalDate dateValue;

    public DateFieldValue() {
        super();
    }
    public DateFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public String getValueAsString() {
        return "";
    }

}
