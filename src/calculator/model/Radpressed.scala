package calculator.model

import calculator.model.add.{RaddPressed, addEqualsPressed}
import calculator.model.divide.RdividePressed
import calculator.model.expansion.{RcosPressed, RplusMinusPressed, RsinPressed}
import calculator.model.multiply.RmultiplyPressed
import calculator.model.subtract.RsubtractPressed

class Radpressed (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.result
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.display = 0
    calculator.lhs = ""
    calculator.rhs = ""
    calculator.result = 0
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.lhs = number.toString
    calculator.rhs = "0"
    calculator.state = new RnumberPressedLHS(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new RdividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new RmultiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new RsubtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new RaddPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.lhs = "0."
    calculator.rhs = "0"
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
