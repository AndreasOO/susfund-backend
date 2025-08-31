package org.andreasoo.susfund.entity.updated.field.value.textfield;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="TEXT")
@Access(AccessType.FIELD)
public class TextFieldValue extends AbstractFieldValue<FieldDefinition> {

    @Column(name="string_value")
    private String stringValue;

    public TextFieldValue(){
        super();
    }

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
