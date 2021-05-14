package calculator.model

import calculator.model.add._
import calculator.model.divide.dividePressed
import calculator.model.expansion.{cosPressed, sinPressed}
import calculator.model.multiply.multiplyPressed
import calculator.model.subtract.subtractPressed

class numberPressedLHS (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.lhs.toDouble
    calculator.display
  }

  override def clearPressed(): Unit = {
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
    calculator.lhs = calculator.lhs + "."
    calculator.state = new decimalPressedLHS(calculator)
  }

  override def plusMinus(): Unit = {
    calculator.lhs = (calculator.lhs.toInt * -1).toString
  }

  override def cosPressed(): Unit = {
    calculator.state = new cosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new sinPressed(calculator)
  }

  override def radPressed(): Unit = {
    calculator.state = new RnumberPressedLHS(calculator)
  }


}