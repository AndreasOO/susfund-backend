package service;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import entity.field.value.AbstractFieldValue;

public interface FieldValueMappingService {
    AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue);

}
