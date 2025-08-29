package org.andreasoo.susfund.entity.updated.field.value.textfield;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="TEXT")
public class TextFieldValue extends AbstractFieldValue<FieldDefinition> {

    @Column(name="string_value")
    String stringValue;

    @Override
    public String getValueAsString() {
        return "";
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
