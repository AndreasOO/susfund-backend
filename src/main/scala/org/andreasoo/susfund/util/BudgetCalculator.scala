package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait BudgetCalculator {
  protected def calculateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  protected def calculateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
