package org.andjos.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andjos.susfund.dao.SupportTypeNodeDao;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;

@ApplicationScoped
public class SupportTypeNodeDaoImpl implements SupportTypeNodeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public SupportTypeNode saveSupportTypeNode(SupportTypeNode stn) {
        return em.merge(stn);
    }

    @Override
    public SupportTypeNode getSupportTypeNodeById(Long id) {
        return em.find(SupportTypeNode.class, id);
    }


}
