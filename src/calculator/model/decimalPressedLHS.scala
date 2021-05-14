package calculator.model

import calculator.model.add.addPressed
import calculator.model.divide.dividePressed
import calculator.model.expansion.{cosPressed, sinPressed}
import calculator.model.multiply.multiplyPressed
import calculator.model.subtract.subtractPressed

class decimalPressedLHS (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.lhs.toDouble
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.lhs = "0"
    calculator.rhs = "0"
    calculator.display = 0.0
    calculator.result = 0.0
    calculator.state = new clearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.lhs = calculator.lhs + number
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

  override def equalsPressed(): Unit = {
  }

  override def decimalPressed(): Unit = {
    calculator.lhs = calculator.lhs
  }

  override def plusMinus(): Unit = {
    calculator.lhs = (calculator.lhs.toDouble * -1).toString
  }


  override def cosPressed(): Unit = {
    calculator.state = new cosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new sinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new RdecimalPressedLHS(calculator)
  }
}
