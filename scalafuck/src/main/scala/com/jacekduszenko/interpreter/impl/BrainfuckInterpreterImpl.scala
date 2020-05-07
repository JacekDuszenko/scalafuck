package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.model.exception.WrongSyntaxException

class BrainfuckInterpreterImpl extends BrainfuckInterpreter {
  override def interpret(code: String): Unit = {
    code.foreach {
      case '>' => print("XD")
      case '<' => print("XD")
      case '+' => print("XD")
      case '-' => print("XD")
      case '.' => print("XD")
      case ',' => print("XD")
      case '[' => print("XD")
      case ']' => print("XD")
      case _ => throw new WrongSyntaxException()
    }
  }
}