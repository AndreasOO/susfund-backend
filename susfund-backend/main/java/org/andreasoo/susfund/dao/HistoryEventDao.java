package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.HistoryEvent;
import org.andreasoo.susfund.entity.Organization;

import java.util.List;

public interface HistoryEventDao {
    List<HistoryEvent> getHistoryEventsByCaseId(int caseId);
}
