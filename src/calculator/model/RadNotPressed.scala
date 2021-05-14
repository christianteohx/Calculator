package calculator.model

import calculator.model.add.{RaddPressed, addPressed}
import calculator.model.divide.{RdividePressed, dividePressed}
import calculator.model.expansion.{RcosPressed, RplusMinusPressed, RsinPressed, cosPressed, plusMinusPressed, sinPressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class RadNotPressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.result
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.display = 0
    calculator.lhs = ""
    calculator.rhs = ""
    calculator.result = 0
    calculator.state = new clearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.lhs = number.toString
    calculator.rhs = "0"
    calculator.state = new numberPressedLHS(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new multiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.lhs = calculator.result.toString
    calculator.rhs = "0"
    calculator.state = new addPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.lhs = "0."
    calculator.rhs = "0"
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
