package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFullFunctionality extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
    }

  test("Test 1") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(3)
    calculator.multiplyPressed() // *
    calculator.addPressed()
    calculator.numberPressed(4)
    calculator.equalsPressed() // =

    assert(equalDoubles(calculator.displayNumber(), 7.0), calculator.displayNumber())
  }
  test("Test 2") {

    val calculator: Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.addPressed()
    calculator.numberPressed(2)
    calculator.multiplyPressed()
    calculator.decimalPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed() // =

    assert(equalDoubles(calculator.displayNumber(), 2.4), calculator.displayNumber())
  }
  test("Test 3") {

    val calculator: Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.equalsPressed() // =
    calculator.numberPressed(3)

    assert(equalDoubles(calculator.displayNumber(), 3.0), calculator.displayNumber())
  }


  test("Test clear") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(3)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.numberPressed(3)
    calculator.clearPressed()
    calculator.numberPressed(1)
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.equalsPressed()

    assert(equalDoubles(calculator.displayNumber(), 2.0), calculator.displayNumber())
  }
  test("Test 4") {

    val calculator: Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.addPressed()
    calculator.numberPressed(1)
    calculator.clearPressed()
    calculator.numberPressed(2)
    calculator.addPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed() // =
    calculator.addPressed()
    calculator.numberPressed(4)
    calculator.equalsPressed()


    assert(equalDoubles(calculator.displayNumber(), 9.0), calculator.displayNumber())
  }

}
