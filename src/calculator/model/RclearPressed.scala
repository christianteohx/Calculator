package calculator.model

class RclearPressed(calculator: Calculator) extends CalculatorState (calculator) {
  override def displayNumber(): Double = {
    calculator.lhs = ""
    calculator.rhs = ""
    calculator.display = 0
    calculator.result = 0
    calculator.display
  }

  override def clearPressed(): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    calculator.lhs = calculator.lhs + number
    calculator.state = new RnumberPressedLHS(calculator)
  }

  override def dividePressed(): Unit = {}

  override def multiplyPressed(): Unit = {}

  override def subtractPressed(): Unit = {}

  override def addPressed(): Unit = {}

  override def equalsPressed(): Unit = {}

  override def decimalPressed(): Unit = {
    calculator.lhs = "0."
    calculator.state = new RdecimalPressedLHS(calculator)
  }
  override def cosPressed(): Unit = {}

  override def sinPressed(): Unit = {}

  override def radPressed(): Unit = {
    calculator.state = new clearPressed(calculator)
  }

}