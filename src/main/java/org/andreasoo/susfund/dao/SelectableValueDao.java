package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.updated.SelectableValue;

import java.util.List;

public interface SelectableValueDao {
    List<SelectableValue> saveSelectableValues(List<SelectableValue> selectableValues);
    List<SelectableValue> getAllSelectableValues();

}
