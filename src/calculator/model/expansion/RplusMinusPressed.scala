package calculator.model.expansion

import calculator.model._
import calculator.model.add.{RaddPressed, addPressed}
import calculator.model.divide.{RdividePressed, divideEqualsPressed, dividePressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class RplusMinusPressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.result = calculator.result * -1
    calculator.result
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

  override def cosPressed(): Unit = {
    calculator.state = new RcosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new RsinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new Radpressed(calculator)
  }

}