package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.old.HistoryEvent;

import java.util.List;

public interface HistoryEventDao {
    List<HistoryEvent> getHistoryEventsByCaseId(int caseId);
}
