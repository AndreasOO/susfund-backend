package org.andreasoo.susfund.util

import jakarta.enterprise.context.ApplicationScoped
import org.andreasoo.susfund.entity.{BudgetPost, CaseBudget}

import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success, Try}

trait BudgetDefaultUtil extends BudgetCalculator with BudgetValidator with FinancingCalculator with FinancingValidator
{

  def createNewBudget(caseBudget: CaseBudget):Result[CaseBudget]

  def updateExistingBudget(caseBudget: CaseBudget):Result[CaseBudget]

  def createNewFinancing(caseBudget: CaseBudget): Result[CaseBudget]

  def updateExistingFinancing(caseBudget: CaseBudget): Result[CaseBudget]

  override protected def calculateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {

    val overHeadPercentage = for {

      budget <- caseBudget // här har vi case budget

      budgetPosts <- Try(Set.from(budget.getBudgetPosts.asScala)) // här hämtar vi budgetposts

      totalBudget <- Try(budgetPosts.map(_.getEstimatedCost).sum) // här räknas summan ut av alla budgetposts

      totalOverhead <- Try(budgetPosts.filter(_.getBudgetPostType.getName == "OVERHEAD") // filtrerar ut budgetposter typ OVERHEAD och summerar den kostnaden
                                      .map(_.getEstimatedCost)
                                      .sum)

      totalOverheadPercentage <- Try(totalOverhead * 100 / totalBudget) // overheadkostnaden i procent av den totala budgeten

    } yield totalOverheadPercentage

    overHeadPercentage match {
      case Failure(exception) => Failure(exception)
      case Success(percent) if percent == 0 => Failure(new IllegalArgumentException("No Overhead"))
      case Success(percent) if percent < 15  => Failure(new IllegalArgumentException("Overhead too low"))
      case Success(percent) if percent > 30  => Failure(new IllegalArgumentException("Overhead high low"))
      case Success(percent) if percent > 15  => Success(caseBudget.get)
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override def calculateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    val overHeadPercentage = for {

      budget <- caseBudget

      budgetPosts <- Try(Set.from(budget.getBudgetPosts.asScala))

      totalBudget <- Try(budgetPosts.map(_.getEstimatedCost).sum)

      totalOverhead <- Try(budgetPosts.filter(_.getBudgetPostType.getName == "OVERHEAD")
        .map(_.getEstimatedCost)
        .sum)

      totalOverheadPercentage <- Try(totalOverhead * 100 / totalBudget)

    } yield totalOverheadPercentage

    overHeadPercentage match {
      case Failure(exception) => Failure(exception)
      case Success(percent) if percent == 0 => Failure(new IllegalArgumentException("No Overhead"))
      case Success(percent) if percent < 15  => Failure(new IllegalArgumentException("Overhead too low"))
      case Success(percent) if percent > 30  => Failure(new IllegalArgumentException("Overhead high low"))
      case Success(percent) if percent > 15  => Success(caseBudget.get)
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override def validateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    val emptyCostPosts = for {

      budget <- caseBudget

      budgetPosts <- Try(Set.from(budget.getBudgetPosts.asScala))

      emptyCostPosts <- Try(budgetPosts.map(_.getEstimatedCost).filter(_ == 0))

    } yield emptyCostPosts

    emptyCostPosts match {
      case Failure(exception) => Failure(exception)
      case Success(posts) if posts.nonEmpty => Failure(new IllegalArgumentException("Empty Cost Posts"))
      case Success(posts) if posts.isEmpty => Success(caseBudget.get)
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override def validateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    val emptyCostPosts = for {

      budget <- caseBudget

      budgetPosts <- Try(Set.from(budget.getBudgetPosts.asScala))

      emptyCostPosts <- Try(budgetPosts.map(_.getEstimatedCost).filter(_ == 0))

    } yield emptyCostPosts

    emptyCostPosts match {
      case Failure(exception) => Failure(exception)
      case Success(posts) if posts.nonEmpty => Failure(new IllegalArgumentException("Empty Cost Posts"))
      case Success(posts) if posts.isEmpty => Success(caseBudget.get)
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override def calculateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    val financingPercentage = for {
      budget <- caseBudget

      financing <- Try(Set.from(budget.getFinancing.asScala))
      totalFinancing = financing.map(inMoney => inMoney.getEstimatedFinancingInMoney).sum

      budgetPosts <- Try(Set.from(budget.getBudgetPosts.asScala))
      totalBudget = budgetPosts.map(budget => budget.getEstimatedCost).sum

    } yield (totalFinancing / totalBudget) * 100

    financingPercentage match {
      case Failure(exception) => Failure(exception)
      case Success(financing) if financing > 50 => Success(caseBudget.get)
      case Success(financing) if financing > 100 => Failure(new IllegalArgumentException("Financing should not exceed budget"))
      case Success(financing) if financing < 50 => Failure(new IllegalArgumentException("Financing does not reach the goal"))
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override def calculateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {

    val financingPercentage = for {
      budget <- caseBudget

      financing <- Try(Set.from(budget.getFinancing.asScala))
      totalFinancing = financing.map(inMoney => inMoney.getEstimatedFinancingInMoney).sum

      budgetPosts <- Try(Set.from(budget.getBudgetPosts.asScala))
      totalBudget = budgetPosts.map(budget => budget.getEstimatedCost).sum

    } yield (totalFinancing / totalBudget) * 100

    financingPercentage match {
      case Failure(exception) => Failure(exception)
      case Success(financing) if financing > 50 => Success(caseBudget.get)
      case Success(financing) if financing > 100 => Failure(new IllegalArgumentException("Financing should not exceed budget"))
      case Success(financing) if financing < 50 => Failure(new IllegalArgumentException("Financing does not reach the goal"))
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override def validateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    caseBudget
  }

  override def validateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    caseBudget
  }
}
