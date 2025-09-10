package org.andreasoo.susfund.entity.field.definition.selectable;

import jakarta.persistence.*;

@Entity
@Table(name="selectable_value")
public class SelectableValue {

    public SelectableValue(){

    }

    public SelectableValue(SelectableType selectableType, String value, Long targetKey) {
        this.selectableType = selectableType;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(name="selectable_type")
    @Enumerated(EnumType.STRING)
    SelectableType selectableType;

    String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SelectableType getSelectableType() {
        return selectableType;
    }

    public void setSelectableType(SelectableType selectableType) {
        this.selectableType = selectableType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
