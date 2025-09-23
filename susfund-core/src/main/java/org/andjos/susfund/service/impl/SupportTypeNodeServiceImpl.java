package org.andjos.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.dao.SupportTypeNodeDao;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.service.SupportTypeNodeService;

@ApplicationScoped
public class SupportTypeNodeServiceImpl implements SupportTypeNodeService {

    @Inject
    private SupportTypeNodeDao supportTypeNodeDao;

    @Override
    public SupportTypeNode saveSupportTypeNode(SupportTypeNode supportTypeNode) {
        return supportTypeNodeDao.saveSupportTypeNode(supportTypeNode);
    }
}
