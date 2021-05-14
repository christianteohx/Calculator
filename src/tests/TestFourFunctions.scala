package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFourFunctions extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  test("Test 1") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(5)
    calculator.multiplyPressed() // *
    calculator.numberPressed(4)
    calculator.equalsPressed() // =

    assert(equalDoubles(calculator.displayNumber(), 20.0), calculator.displayNumber())
  }

  test("Test 2") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(3)
    calculator.addPressed()
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 7.3), calculator.displayNumber())
  }

  test("Test division") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(2)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(5)
    calculator.equalsPressed() // =

    assert(equalDoubles(calculator.displayNumber(), 5.0), calculator.displayNumber())
  }

  test("Test subtraction") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(5)
    calculator.subtractPressed() //
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.equalsPressed() // =

    assert(equalDoubles(calculator.displayNumber(), 1.0), calculator.displayNumber())
  }

  test("Test rhs decimal") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(5)
    calculator.multiplyPressed() // *
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.equalsPressed() // =

    assert(equalDoubles(calculator.displayNumber(), 22.0), calculator.displayNumber())
  }

}
