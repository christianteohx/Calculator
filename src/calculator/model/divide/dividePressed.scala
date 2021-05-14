package calculator.model.divide

import calculator.model.add.addPressed
import calculator.model._
import calculator.model.expansion.{RcosPressed, RsinPressed, cosPressed, sinPressed}
import calculator.model.multiply.multiplyPressed
import calculator.model.subtract.subtractPressed

class dividePressed (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = 0.0
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.state = new clearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
    calculator.state = new divideNumberPressedRHS(calculator)
  }

  override def dividePressed(): Unit = {}

  override def multiplyPressed(): Unit = {
    calculator.state = new multiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {}

  override def decimalPressed(): Unit = {
    calculator.rhs = calculator.rhs + "0."
    calculator.state = new divideDecimalPressedRHS(calculator)
  }

  override def cosPressed(): Unit = {
    calculator.state = new cosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new sinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new RdividePressed(calculator)
  }
}