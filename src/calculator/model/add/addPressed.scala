package calculator.model.add

import calculator.model._
import calculator.model.divide.dividePressed
import calculator.model.expansion.{cosPressed, sinPressed}
import calculator.model.multiply.multiplyPressed
import calculator.model.subtract.subtractPressed

class addPressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    0.0
  }

  override def clearPressed(): Unit = {
    calculator.state = new clearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.rhs = calculator.rhs + number
    calculator.state = new addNumberPressedRHS(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.state = new dividePressed(calculator)
  }

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
    calculator.rhs = "0."
    calculator.state = new addDecimalPressedRHS(calculator)
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
