package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait FinancingCalculator {
  protected def calculateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  protected def calculateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
