package org.andjos.susfund.mapper.fields;

import jakarta.inject.Inject;
import org.andjos.susfund.dao.FieldValueDao;
import org.andjos.susfund.dto.fieldvalue.NumericFieldValueDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.andjos.susfund.entity.field.value.numericfield.NumericFieldValue;

@ApplicationScoped
public class NumericFieldValueMapper
        implements FieldValueMapper<NumericFieldValue, NumericFieldValueDTO>,
                   FieldDefinitionDTOFactory {

    @Inject
    private FieldValueDao fieldValueDao;

    @Override
    public NumericFieldValueDTO mapToDTO(NumericFieldValue fieldValue) {
        return new NumericFieldValueDTO(
                fieldValue.getId(),
                fieldValue.getOwningCase().getId(),
                createFieldDefinitionDTO(fieldValue.getFieldDefinition()),
                fieldValue.getNumericValue()
        );
    }


    @Override
    public NumericFieldValue mapToEntity(NumericFieldValueDTO dto) {
        NumericFieldValue numericFieldValue = (NumericFieldValue) fieldValueDao.findById(dto.getId());
        numericFieldValue.setNumericValue(dto.getNumericValue());
        return  numericFieldValue;
    }
}
