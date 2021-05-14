package calculator.model


class Calculator() {
  var state: CalculatorState = new clearPressed(this)
  var display: Double = 0.0
  var lhs: String = ""
  var rhs: String = ""
  var result: Double = 0.0

  def displayNumber(): Double = {
    this.state.displayNumber()
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def dividePressed(): Unit = {
    this.state.dividePressed()
  }

  def multiplyPressed(): Unit = {
    this.state.multiplyPressed()
  }

  def subtractPressed(): Unit = {
    this.state.subtractPressed()
  }

  def addPressed(): Unit = {
    this.state.addPressed()
  }

  def equalsPressed(): Unit = {
    this.state.equalsPressed()
  }

  def decimalPressed(): Unit = {
    this.state.decimalPressed()
  }

  def plusMinus(): Unit = {
    this.state.plusMinus()
  }

  def Sin(): Unit = {
    this.state.sinPressed()
  }

  def Cos(): Unit = {
    this.state.cosPressed()
  }

  def Rad(): Unit = {
    this.state.radPressed()
  }

}
