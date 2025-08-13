package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="TEXT")
public class TextFieldValue extends AbstractFieldValue<FieldDefinition> {

    String stringValue;

    @Override
    public String getValueAsString() {
        return "";
    }
}
