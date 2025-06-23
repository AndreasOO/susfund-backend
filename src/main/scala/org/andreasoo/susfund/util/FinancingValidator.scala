package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait FinancingValidator {
  def validateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  def validateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
