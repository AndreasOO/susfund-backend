package org.andreasoo.susfund.dto.fieldvalue;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.andreasoo.susfund.entity.updated.field.value.selectable.SelectableType;

public class SelectableValueDTO {

    Long id;
    String value;
    SelectableType selectableType;

    public SelectableValueDTO(){}

    public SelectableValueDTO(Long id, String value, SelectableType selectableType) {
        this.id = id;
        this.value = value;
        this.selectableType = selectableType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SelectableType getSelectableType() {
        return selectableType;
    }

    public void setSelectableType(SelectableType selectableType) {
        this.selectableType = selectableType;
    }
}
