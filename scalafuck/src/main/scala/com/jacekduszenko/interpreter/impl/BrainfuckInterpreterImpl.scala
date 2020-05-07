package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.model.RuntimeState
import com.jacekduszenko.model.exception.WrongSyntaxException

class BrainfuckInterpreterImpl extends BrainfuckInterpreter {

  val state: RuntimeState = new RuntimeState()
  private var openParenCounter: Int = 0

  override def interpret(code: String): Unit = code.foreach {
    case '>' => state.movePointerToTheLeft()
    case '<' => state.movePointerToTheRight()
    case '+' => state.increasePointerValue()
    case '-' => state.decreasePointerValue()
    case '.' => state.outputByteAtPointer()
    case ',' => state.inputByteAtPointer()
    case '[' => print("XD")
    case ']' => print("XD")
    case _ => throw new WrongSyntaxException()
  }
}