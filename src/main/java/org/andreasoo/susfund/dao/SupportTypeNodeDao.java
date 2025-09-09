package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;
import org.andreasoo.susfund.entity.updated.supporttype.SupportTypeNode;

import java.util.List;

public interface SupportTypeNodeDao {
    SupportTypeNode saveSupportTypeNode(SupportTypeNode stn);
    SupportTypeNode getSupportTypeNodeById(Long id);
}
