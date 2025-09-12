package mapper.fields;

import dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import mapper.EntityToDtoMapper;

public interface FieldValueMapper<T extends AbstractFieldValue<?>, D extends AbstractFieldValueDTO<?>>
        extends EntityToDtoMapper<T, D> {
}
