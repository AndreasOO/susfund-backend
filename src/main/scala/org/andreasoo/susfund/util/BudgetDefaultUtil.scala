package org.andreasoo.susfund.util

import jakarta.enterprise.context.ApplicationScoped
import org.andreasoo.susfund.entity.{BudgetPost, CaseBudget}
import scala.jdk.CollectionConverters._

import scala.util.{Failure, Try}

trait BudgetDefaultUtil extends BudgetCalculator with BudgetValidator
                                                 with FinancingCalculator
                                                 with FinancingValidator
{



  def createNewBudget(caseBudget: CaseBudget):Result[CaseBudget]
  def updateExistingBudget(caseBudget: CaseBudget):Result[CaseBudget]


  // Scala trait methods
  override protected def calculateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    val budgetPosts:Set[BudgetPost] = Set.from(caseBudget.getOrElse(throw new IllegalArgumentException("No budget"))
                                                         .getBudgetPosts
                                                         .asScala)

    for {
      budgetPosts <- Try(Set.from(caseBudget.getOrElse(throw new IllegalArgumentException("No budget"))
                                            .getBudgetPosts
                                            .asScala))

      totalBudget <- Try(budgetPosts.map(_.getEstimatedCost).sum)

    } yield totalBudget





  }

  override protected def calculateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???

  override protected def validateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???

  override protected def validateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???

  override protected def calculateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???

  override protected def calculateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???

  override protected def validateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???

  override protected def validateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = ???
}
