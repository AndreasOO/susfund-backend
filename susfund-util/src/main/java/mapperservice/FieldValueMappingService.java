package mapperservice;

import dto.fielddefinition.FieldDefinitionDTO;
import dto.fieldvalue.AbstractFieldValueDTO;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;

public interface FieldValueMappingService {
    AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue);

}
