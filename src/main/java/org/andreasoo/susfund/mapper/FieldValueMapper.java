package org.andreasoo.susfund.mapper;

import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

public interface FieldValueMapper<T extends AbstractFieldValue<?>, D extends AbstractFieldValueDTO<?>>
        extends EntityToDtoMapper<T, D> {

    D mapToDTO(T fieldValue, Long caseId);


    @Override
    default D mapToDTO(T entity) {
        throw new UnsupportedOperationException("Use mapToDTO(T fieldValue, Long caseId) instead for fieldValue mapping");
    }
}
