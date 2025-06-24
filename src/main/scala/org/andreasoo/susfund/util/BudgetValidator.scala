package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait BudgetValidator {
  def validateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  def validateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
