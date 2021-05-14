package calculator.model.multiply

import calculator.model.add.{RaddPressed, addPressed}
import calculator.model.divide.{RdividePressed, dividePressed}
import calculator.model.expansion.{RcosPressed, RsinPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}
import calculator.model.{Calculator, CalculatorState, RclearPressed, clearPressed}

class RmultiplyNumberPressedRHS(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.rhs.toDouble
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
  }

  override def dividePressed(): Unit = {
    calculator.result = calculator.lhs.toDouble * calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RdividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble * calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RmultiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble * calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RsubtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.result = calculator.lhs.toDouble * calculator.rhs.toDouble
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RaddPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.state = new RmultiplyEqualsPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.rhs = calculator.rhs + "."
    calculator.state = new RmultiplyDecimalPressedRHS(calculator)

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
    calculator.state = new multiplyNumberPressedRHS(calculator)
  }
}
