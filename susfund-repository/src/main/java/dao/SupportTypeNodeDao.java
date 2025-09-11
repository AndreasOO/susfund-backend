package dao;

import entity.supporttype.SupportTypeNode;

public interface SupportTypeNodeDao {
    SupportTypeNode saveSupportTypeNode(SupportTypeNode stn);
    SupportTypeNode getSupportTypeNodeById(Long id);
}
