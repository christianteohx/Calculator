package calculator.model.expansion

import calculator.model.add.addPressed
import calculator.model.divide.dividePressed
import calculator.model.multiply.multiplyPressed
import calculator.model.{Calculator, CalculatorState, Radpressed, clearPressed, decimalPressedLHS, numberPressedLHS}
import calculator.model.subtract.subtractPressed

class sinPressed (calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.result = math.sin(calculator.display * math.Pi/180)
    calculator.result
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