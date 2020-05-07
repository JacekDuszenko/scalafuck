package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import org.scalatest.{BeforeAndAfterEach, FunSuite, TestSuiteMixin}

class InterpreterIntegrationTest extends FunSuite with BeforeAndAfterEach {

  val bfInterpreter: BrainfuckInterpreter = new BrainfuckInterpreterImpl()

  test("Should execute example brainfuck program correctly") {
    val stringInput = "++>+++++"
    bfInterpreter.interpret(stringInput)
  }
}
