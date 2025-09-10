package org.andreasoo.susfund.service;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.field.value.AbstractFieldValue;

public interface FieldValueMappingService {
    AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue);

}
