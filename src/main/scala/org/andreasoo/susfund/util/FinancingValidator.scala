package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait FinancingValidator {
  protected def validateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  protected def validateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  protected def validateExistingFinancing2(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
