package org.andjos.susfund.dao;

import org.andjos.susfund.entity.field.definition.FieldDefinition;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

import java.util.List;

public interface FieldValueDao {
    AbstractFieldValue<? extends FieldDefinition> findById(Long id);
    AbstractFieldValue<? extends FieldDefinition> save(AbstractFieldValue<? extends FieldDefinition>  fieldValue);
}
