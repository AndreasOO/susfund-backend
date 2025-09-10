package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.supporttype.SupportTypeNode;

public interface SupportTypeNodeDao {
    SupportTypeNode saveSupportTypeNode(SupportTypeNode stn);
    SupportTypeNode getSupportTypeNodeById(Long id);
}
