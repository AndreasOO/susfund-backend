package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.HistoryEventDao;
import org.andreasoo.susfund.entity.HistoryEvent;

import java.util.List;

@ApplicationScoped
public class HistoryEventDaoImpl implements HistoryEventDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HistoryEvent> getHistoryEventsByCaseId(int caseId) {
        return entityManager.createQuery(
                "select he from Cases c join c.historyEventList he where c.id=" + caseId, HistoryEvent.class).getResultList();
    }
}
