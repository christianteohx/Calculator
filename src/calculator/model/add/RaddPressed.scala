package calculator.model.add

import calculator.model._
import calculator.model.divide.{RdividePressed, dividePressed}
import calculator.model.expansion.{RcosPressed, RsinPressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class RaddPressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    0.0
  }

  override def clearPressed(): Unit = {
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
    calculator.state = new RaddNumberPressedRHS(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.state = new RdividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.state = new RmultiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.state = new RsubtractPressed(calculator)

  }

  override def addPressed(): Unit = {
    calculator.state = new RaddPressed(calculator)
  }

  override def equalsPressed(): Unit = {}

  override def decimalPressed(): Unit = {
    calculator.rhs = "0."
    calculator.state = new RaddDecimalPressedRHS(calculator)
  }

  override def cosPressed(): Unit = {
    calculator.state = new RcosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new RsinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }
}
