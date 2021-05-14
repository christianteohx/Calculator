package calculator.model

abstract class CalculatorState(calculator: Calculator) {
  def displayNumber(): Double = {
    calculator.display
  }

  def clearPressed(): Unit = {}

  def numberPressed(number: Int): Unit = {}

  def dividePressed(): Unit = {}

  def multiplyPressed(): Unit = {}

  def subtractPressed(): Unit = {}

  def addPressed(): Unit = {}

  def equalsPressed(): Unit = {}

  def decimalPressed(): Unit = {}

  def plusMinus(): Unit = {}

  def sinPressed(): Unit = {}

  def cosPressed(): Unit = {}

  def radPressed(): Unit = {}


}