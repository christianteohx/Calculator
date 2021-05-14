package calculator.model.add

import calculator.model._
import calculator.model.divide.{RdividePressed, dividePressed}
import calculator.model.expansion.{RcosPressed, RsinPressed, cosPressed, sinPressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class addNumberPressedRHS(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.rhs.toDouble
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.lhs = ""
    calculator.rhs = ""
    calculator.display = 0.0
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
  }

  override def dividePressed(): Unit = {
    calculator.lhs = (calculator.lhs.toDouble + calculator.rhs.toDouble).toString
    calculator.rhs = ""
    calculator.state = new RdividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.lhs = (calculator.lhs.toDouble + calculator.rhs.toDouble).toString
    calculator.rhs = ""
    calculator.state = new RmultiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.lhs = (calculator.lhs.toDouble + calculator.rhs.toDouble).toString
    calculator.rhs = ""
    calculator.state = new RsubtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.lhs = (calculator.lhs.toDouble + calculator.rhs.toDouble).toString
    calculator.rhs = ""
    calculator.state = new RaddPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble + calculator.rhs.toDouble
    calculator.state = new RaddEqualsPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.rhs = calculator.rhs + "."
    calculator.state = new RaddDecimalPressedRHS(calculator)
  }

  override def plusMinus(): Unit = {
    calculator.rhs = (calculator.rhs.toInt * -1).toString
  }

  override def cosPressed(): Unit = {
    calculator.state = new RcosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new RsinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new RaddNumberPressedRHS(calculator)
  }
}
