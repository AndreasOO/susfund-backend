package org.andjos.susfund.dao;

import org.andjos.susfund.entity.supporttype.SupportTypeNode;

public interface SupportTypeNodeDao {
    SupportTypeNode saveSupportTypeNode(SupportTypeNode stn);
    SupportTypeNode getSupportTypeNodeById(Long id);
}
