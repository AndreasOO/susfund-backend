package service;

import dto.fielddefinition.FieldDefinitionDTO;
import dto.fieldvalue.AbstractFieldValueDTO;
import entity.field.value.AbstractFieldValue;

public interface FieldValueMappingService {
    AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue);

}
