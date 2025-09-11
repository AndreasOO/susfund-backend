package entity.field.value.textfield;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import entity.caseentity.CaseEntity;
import entity.field.definition.FieldDefinition;
import entity.field.value.AbstractFieldValue;

@Entity
@DiscriminatorValue(value="TEXT")
public class TextFieldValue extends AbstractFieldValue<FieldDefinition> {

    public TextFieldValue() {
        super();
    }

    public TextFieldValue(CaseEntity owningCase) {
        super(owningCase);
    }

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
