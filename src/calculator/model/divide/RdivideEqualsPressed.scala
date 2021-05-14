package calculator.model.divide

import calculator.model._
import calculator.model.add.{RaddPressed, addPressed}
import calculator.model.expansion.{RcosPressed, RplusMinusPressed, RsinPressed, cosPressed, plusMinusPressed, sinPressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class RdivideEqualsPressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.result = calculator.lhs.toDouble / calculator.rhs.toDouble
    calculator.result
  }

  override def clearPressed(): Unit = {
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.state = new RnumberPressedLHS(calculator)
    calculator.lhs = number.toString
    calculator.rhs = ""
  }

  override def dividePressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new RdivideNumberPressedRHS(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RmultiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RsubtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = ""
    calculator.state = new RaddPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.lhs = "0."
    calculator.rhs = ""
    calculator.state = new RdecimalPressedLHS(calculator)
  }

  override def plusMinus(): Unit = {
    calculator.display = calculator.result * -1
    calculator.state = new RplusMinusPressed(calculator)
  }

  override def cosPressed(): Unit = {
    calculator.state = new RcosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new RsinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new RadNotPressed(calculator)
  }

}
