package service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import dao.SupportTypeNodeDao;
import entity.supporttype.SupportTypeNode;
import service.SupportTypeNodeService;

@ApplicationScoped
public class SupportTypeNodeServiceImpl implements SupportTypeNodeService {

    @Inject
    private SupportTypeNodeDao supportTypeNodeDao;

    @Override
    public SupportTypeNode saveSupportTypeNode(SupportTypeNode supportTypeNode) {
        return supportTypeNodeDao.saveSupportTypeNode(supportTypeNode);
    }
}
