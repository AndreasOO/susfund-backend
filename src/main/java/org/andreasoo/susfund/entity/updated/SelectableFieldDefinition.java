package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
@DiscriminatorValue(value="SELECTABLE")
public class SelectableFieldDefinition extends FieldDefinition {

    @OneToMany
    @JoinColumn(name="field_defition_entity_id")
    Set<SelectableValue> selectableValues;

}
