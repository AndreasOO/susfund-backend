package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@DiscriminatorValue(value="SELECTABLE")
public class SelectableFieldDefinition extends FieldDefinition {

    public  SelectableFieldDefinition() {
        super();
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="field_definition_entity_id")
    protected Set<SelectableValue> selectableValues;


    public Set<SelectableValue> getSelectableValues() {
        return selectableValues;
    }

    public void setSelectableValues(Set<SelectableValue> selectableValues) {
        this.selectableValues = selectableValues;
    }


}
