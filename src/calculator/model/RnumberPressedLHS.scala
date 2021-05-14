package calculator.model

import calculator.model.add._
import calculator.model.divide.{RdividePressed, dividePressed}
import calculator.model.expansion.{RcosPressed, RsinPressed, cosPressed, sinPressed}
import calculator.model.multiply.{RmultiplyPressed, multiplyPressed}
import calculator.model.subtract.{RsubtractPressed, subtractPressed}

class RnumberPressedLHS(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.display = calculator.lhs.toDouble
    calculator.display
  }

  override def clearPressed(): Unit = {
    calculator.state = new RclearPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.lhs = calculator.lhs + number
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

  override def equalsPressed(): Unit = {
  }

  override def decimalPressed(): Unit = {
    calculator.lhs = calculator.lhs + "."
    calculator.state = new RdecimalPressedLHS(calculator)
  }

  override def plusMinus(): Unit = {
    calculator.lhs = (calculator.lhs.toInt * -1).toString
  }

  override def cosPressed(): Unit = {
    calculator.state = new RcosPressed(calculator)
  }

  override def sinPressed(): Unit = {
    calculator.state = new RsinPressed(calculator)
  }


  override def radPressed(): Unit = {
    calculator.state = new RnumberPressedLHS(calculator)
  }

}