package org.andreasoo.susfund.service;

import org.andreasoo.susfund.dto.fielddefinition.FieldDefinitionDTO;
import org.andreasoo.susfund.dto.fieldvalue.AbstractFieldValueDTO;
import org.andreasoo.susfund.entity.updated.field.value.AbstractFieldValue;

import java.util.List;

public interface FieldValueMappingService {
    AbstractFieldValueDTO<? extends FieldDefinitionDTO> mapFieldValueToDTO(AbstractFieldValue<?> fieldValue, Long caseId);
    List<AbstractFieldValueDTO<? extends FieldDefinitionDTO>> mapFieldValuesToDTOs(List<? extends AbstractFieldValue<?>> fieldValues, Long caseId);
}
