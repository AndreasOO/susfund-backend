package org.andjos.susfund.mapper.fields;

import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import org.andjos.susfund.mapper.EntityToDtoMapper;

public interface FieldValueMapper<T extends AbstractFieldValue<?>, D extends AbstractFieldValueDTO<?>>
        extends EntityToDtoMapper<T, D> {
}
