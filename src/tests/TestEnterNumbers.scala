package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestEnterNumbers extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  // Example test case
  test("Test 1") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(4)
    calculator.numberPressed(1)
    calculator.numberPressed(7)

    assert(equalDoubles(calculator.displayNumber(), 417), calculator.displayNumber())
  }

  test("Test 2") {

    val calculator: Calculator = new Calculator()

    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(3)

    assert(equalDoubles(calculator.displayNumber(), 2.3), calculator.displayNumber())
  }

  test("Test 3") {

    val calculator: Calculator = new Calculator()

    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.decimalPressed()
    calculator.numberPressed(5)

    assert(equalDoubles(calculator.displayNumber(), 2.35), calculator.displayNumber())
  }

  test("Test 4") {

    val calculator: Calculator = new Calculator()

    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(5)

    assert(equalDoubles(calculator.displayNumber(), 0.0005), calculator.displayNumber())
  }

  test("Test 5") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(6)
    calculator.numberPressed(8)
    calculator.numberPressed(9)

    assert(equalDoubles(calculator.displayNumber(), 689), calculator.displayNumber())
  }

}
