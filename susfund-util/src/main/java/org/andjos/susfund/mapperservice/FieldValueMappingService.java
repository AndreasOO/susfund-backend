package org.andjos.susfund.mapperservice;

import org.andjos.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andjos.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

public interface FieldValueMappingService {
    AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue);

}
