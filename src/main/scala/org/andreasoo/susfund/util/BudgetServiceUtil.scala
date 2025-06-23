package org.andreasoo.susfund.util

import org.andreasoo.susfund.entity.CaseBudget

import scala.util.{Failure, Success, Try}

class BudgetServiceUtil extends BudgetDefaultUtil {

  override def createNewBudget(caseBudget: CaseBudget): Result[CaseBudget] = {

    val calculatedBudget = for {
      validatedBudget <- validateNewBudget(Try(caseBudget))
      calculatedBudget <- calculateNewBudget(Try(validatedBudget))

    } yield calculatedBudget

    calculatedBudget match {
      case Success(budget) => Result(budget)
      case Failure(exception) => Result(caseBudget, exception.getMessage, success = false)
    }
  }


  override def updateExistingBudget(caseBudget: CaseBudget): Result[CaseBudget] = {

    val calculatedBudget = for {
      validatedBudget <- validateNewBudget(Try(caseBudget))
      calculatedBudget <- calculateNewBudget(Try(validatedBudget))

    } yield calculatedBudget

    calculatedBudget match {
      case Success(budget) => Result(budget)
      case Failure(exception) => Result(caseBudget, exception.getMessage, success = false)
    }
  }

}
