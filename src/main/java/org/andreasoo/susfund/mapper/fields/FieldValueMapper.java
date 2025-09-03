package org.andreasoo.susfund.mapper.fields;

import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;
import org.andreasoo.susfund.mapper.EntityToDtoMapper;

public interface FieldValueMapper<T extends AbstractFieldValue<?>, D extends AbstractFieldValueDTO<?>>
        extends EntityToDtoMapper<T, D> {
}
