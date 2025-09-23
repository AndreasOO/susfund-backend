package org.andjos.susfund.dto.fieldvalue;

import org.andjos.susfund.dto.AbstractDTO;
import org.andjos.susfund.entity.field.definition.selectable.SelectableType;

public class SelectableValueDTO extends AbstractDTO {

    Long id;
    String value;
    SelectableType selectableType;

    public SelectableValueDTO() {
        super("selectableValue");
    }

    public SelectableValueDTO(Long id, String value, SelectableType selectableType) {
        super("selectableValue");
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
