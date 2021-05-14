package calculator.model.subtract

import calculator.model.add.addPressed
import calculator.model.divide.dividePressed
import calculator.model.expansion.{cosPressed, sinPressed}
import calculator.model.multiply.multiplyPressed
import calculator.model.{Calculator, CalculatorState, clearPressed}

class subtractNumberPressedRHS (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.rhs.toDouble
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.state = new clearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
  }

  override def dividePressed(): Unit = {
    calculator.result = calculator.lhs.toDouble + calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble + calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new multiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble + calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble + calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.state = new subtractEqualsPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.rhs = calculator.rhs + "."
    calculator.state = new subtractDecimalPressedRHS(calculator)

  }

  override def plusMinus(): Unit = {
    calculator.rhs = (calculator.rhs.toInt * -1).toString
  }

  override def cosPressed(): Unit = {
    calculator.state = new cosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new sinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new RsubtractNumberPressedRHS(calculator)
  }
}