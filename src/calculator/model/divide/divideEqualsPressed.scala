package calculator.model.divide

import calculator.model.add.addPressed
import calculator.model._
import calculator.model.expansion.{cosPressed, plusMinusPressed, sinPressed}
import calculator.model.multiply.multiplyPressed
import calculator.model.subtract.subtractPressed

class divideEqualsPressed  (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.result = calculator.lhs.toDouble / calculator.rhs.toDouble
    calculator.result
  }

  override def clearPressed(): Unit = {
    calculator.state = new clearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.state = new numberPressedLHS(calculator)
    calculator.lhs = number.toString
    calculator.rhs = ""
  }

  override def dividePressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new divideNumberPressedRHS(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new multiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new addPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.lhs = "0."
    calculator.rhs = ""
    calculator.state = new decimalPressedLHS(calculator)
  }

  override def plusMinus(): Unit = {
    calculator.display = calculator.result * -1
    calculator.state = new plusMinusPressed(calculator)
  }

  override def cosPressed(): Unit = {
    calculator.state = new cosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new sinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new Radpressed(calculator)
  }

}
