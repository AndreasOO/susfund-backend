package org.andjos.susfund.dao;

import org.andjos.susfund.entity.field.definition.selectable.SelectableValue;

import java.util.List;

public interface SelectableValueDao {
    List<SelectableValue> saveSelectableValues(List<SelectableValue> selectableValues);
    List<SelectableValue> getAllSelectableValues();
}
