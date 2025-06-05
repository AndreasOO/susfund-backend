package org.andreasoo.susfund.service

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class BudgetServiceImpl extends BudgetService {
  override def test(x: Int): String = s"success: $x"
}
