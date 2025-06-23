package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.Try

trait FinancingCalculator {
  def calculateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
  def calculateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget]
}
