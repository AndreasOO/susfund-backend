package org.andreasoo.susfund.entity.updated.field.definition.selectable;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.field.value.selectable.SelectableValue;

import java.util.Set;

@Entity
@DiscriminatorValue(value="SELECTABLE")
public class SelectableFieldDefinition extends FieldDefinition {

    public  SelectableFieldDefinition() {
        super();
    }

//    @OneToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.PERSIST, fetch =  FetchType.EAGER)
    @JoinTable(
            name="fdn_slv",
            joinColumns = {@JoinColumn(name="field_definition_id")},
            inverseJoinColumns = {@JoinColumn(name="selectable_value_id")}
    )
    protected Set<SelectableValue> selectableValues;


    public Set<SelectableValue> getSelectableValues() {
        return selectableValues;
    }

    public void setSelectableValues(Set<SelectableValue> selectableValues) {
        this.selectableValues = selectableValues;
    }


}
