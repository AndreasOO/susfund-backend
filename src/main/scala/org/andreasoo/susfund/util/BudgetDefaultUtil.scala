package org.andreasoo.susfund.util

import jakarta.enterprise.context.ApplicationScoped
import org.andreasoo.susfund.entity.{BudgetPost, CaseBudget, Financing}

import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success, Try}

trait BudgetDefaultUtil extends BudgetCalculator with BudgetValidator
                                                 with FinancingCalculator
                                                 with FinancingValidator {


  def handleNewBudget(caseBudget: CaseBudget): Try[CaseBudget] = {
    for {
      validatedBudget <- validateNewBudget(Try(caseBudget))
      calculatedBudget <- calculateNewBudget(Try(validatedBudget))

    } yield calculatedBudget
  }

  def handleExistingBudget(caseBudget: CaseBudget): Try[CaseBudget] = {
    for {
      validatedBudget <- validateNewBudget(Try(caseBudget))
      calculatedBudget <- calculateNewBudget(Try(validatedBudget))

    } yield calculatedBudget
  }

  def handleExistingFinancing(caseBudget: CaseBudget): Try[CaseBudget] = {
    for {
      validatedFinancing <- validateExistingFinancing(Try(caseBudget))
      calculatedFinancing <- calculateExistingFinancing(Try(validatedFinancing))
    } yield calculatedFinancing
  }

  def createNewBudget(caseBudget: CaseBudget): Result[CaseBudget]

  def updateExistingBudget(caseBudget: CaseBudget): Result[CaseBudget]

  def updateExistingFinancing(caseBudget: CaseBudget): Result[CaseBudget]


  override protected def calculateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {

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
      case Success(percent) if percent == 0 => Failure(new IllegalArgumentException("No Overhead"))
      case Success(percent) if percent < 15 => Failure(new IllegalArgumentException("Overhead too low"))
      case Success(percent) if percent > 30 => Failure(new IllegalArgumentException("Overhead high low"))
      case Success(percent) if percent > 15 => Success(caseBudget.get)
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override protected def calculateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
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
      case Success(percent) if percent == 0 => Failure(new IllegalArgumentException("No Overhead"))
      case Success(percent) if percent < 15 => Failure(new IllegalArgumentException("Overhead too low"))
      case Success(percent) if percent > 30 => Failure(new IllegalArgumentException("Overhead high low"))
      case Success(percent) if percent > 15 => Success(caseBudget.get)
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override protected def validateNewBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
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

  override protected def validateExistingBudget(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
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

  override protected def calculateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    caseBudget
  }

  override protected def validateNewFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    caseBudget
  }

  override protected def calculateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    val calculatedPercentage = for {
      budget <- caseBudget

      financing <- Try(List.from(budget.getFinancing.asScala))
      totalFinancing = financing.map(inMoney => inMoney.getEstimatedFinancingInMoney).sum

      budgetPosts <- Try(List.from(budget.getBudgetPosts.asScala))
      totalBudget = budgetPosts.map(budget => budget.getEstimatedCost).sum

      _ <- if (totalBudget == 0)
        Failure(new IllegalArgumentException("Total budget is zero"))
      else
        Success(())

    } yield (totalFinancing.toDouble / totalBudget.toDouble) * 100

    calculatedPercentage match {
      case Failure(exception) => Failure(exception)
      case Success(financing) if financing > 100 => Failure(new IllegalArgumentException("Financing should not exceed budget"))
      case Success(financing) if financing >= 50 => caseBudget
      case Success(financing) if financing < 50 => Failure(new IllegalArgumentException("Financing does not reach the goal"))
      case _ => Failure(new IllegalArgumentException("Unknown error"))
    }
  }

  override protected def validateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
    caseBudget.flatMap { budget =>
      val totalBudget = budget.getBudgetPosts.asScala.map((post: BudgetPost) => post.getEstimatedCost).sum
      val financingList = budget.getFinancing.asScala.toList
      val errors = getFinancingErrors(financingList, totalBudget)

      if (errors.isEmpty) Success(budget)
      else {
        Failure(new IllegalArgumentException("Mismatch between estimated financing in money and the expected value based on its percentage of the total budget"))
      }
    }
  }

  private def getFinancingErrors(financing: List[Financing], totalBudget: Int): List[Financing] = {
    financing.filter { finance =>
      val expected = finance.getEstimatedFinancingInPercentage * 0.01 * totalBudget
      math.round(expected) != finance.getEstimatedFinancingInMoney
    }
  }


  //  override protected def validateExistingFinancing(caseBudget: Try[CaseBudget]): Try[CaseBudget] = {
  //    val financingErrors = for {
  //      budget <- caseBudget
  //      totalBudget = budget.getBudgetPosts.asScala.map((post: BudgetPost) => post.getEstimatedCost).sum
  //      errors = budget.getFinancing.asScala.toList.filter { finance =>
  //        val expected = finance.getEstimatedFinancingInPercentage * 0.01 * totalBudget
  //        math.round(expected) != finance.getEstimatedFinancingInMoney
  //      }
  //    } yield errors
  //
  //    financingErrors.flatMap(errors => {
  //      if (errors.isEmpty) caseBudget
  //      else Failure(new IllegalArgumentException("Errors in financing"))
  //    })
  //  }

}
