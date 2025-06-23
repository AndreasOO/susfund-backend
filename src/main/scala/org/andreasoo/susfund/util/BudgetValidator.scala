package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait BudgetValidator {
  protected def validateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  protected def validateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
