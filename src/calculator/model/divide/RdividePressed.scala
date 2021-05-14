package calculator.model.divide

import calculator.model._
import calculator.model.add.{RaddPressed, addPressed}
import calculator.model.expansion.{RcosPressed, RsinPressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class RdividePressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = 0.0
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
    calculator.state = new RdivideNumberPressedRHS(calculator)
  }

  override def dividePressed(): Unit = {}

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
    calculator.rhs = calculator.rhs + "0."
    calculator.state = new RdivideDecimalPressedRHS(calculator)
  }


  override def cosPressed(): Unit = {
    calculator.state = new RcosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new RsinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new dividePressed(calculator)
  }

}