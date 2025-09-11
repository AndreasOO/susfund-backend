package mapper.fields;

import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import entity.field.value.AbstractFieldValue;
import mapper.EntityToDtoMapper;

public interface FieldValueMapper<T extends AbstractFieldValue<?>, D extends AbstractFieldValueDTO<?>>
        extends EntityToDtoMapper<T, D> {
}
