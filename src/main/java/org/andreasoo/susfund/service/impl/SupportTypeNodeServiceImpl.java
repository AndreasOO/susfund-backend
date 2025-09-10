package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dao.SupportTypeNodeDao;
import org.andreasoo.susfund.entity.supporttype.SupportTypeNode;
import org.andreasoo.susfund.service.SupportTypeNodeService;

@ApplicationScoped
public class SupportTypeNodeServiceImpl implements SupportTypeNodeService {

    @Inject
    private SupportTypeNodeDao supportTypeNodeDao;

    @Override
    public SupportTypeNode saveSupportTypeNode(SupportTypeNode supportTypeNode) {
        return supportTypeNodeDao.saveSupportTypeNode(supportTypeNode);
    }
}
