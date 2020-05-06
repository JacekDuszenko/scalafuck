package com.jacekduszenko.interpreter.impl

import org.scalatest.{BeforeAndAfterEach, FunSuite, TestSuiteMixin}

class InterpreterIntegrationTest extends FunSuite with BeforeAndAfterEach {

  val bfInterpreter: BrainfuckInterpreterImpl = BrainfuckInterpreterImpl()

  test("Should execute example brainfuck program correctly") {
    val stringInput = "++>+++++"
    bfInterpreter.interpret(stringInput)
  }
}
