package com.jacekduszenko.interpreter

import com.jacekduszenko.model._

trait BrainfuckInterpreter {

  def interpret(code: String): Unit

  protected def fromString(code: String): List[BrainfuckToken] = code.toList.map {
    case '>' => IncrementPointer
    case '<' => DecrementPointer
    case '+' => IncrementValue
    case '-' => DecrementPointer
    case '.' => PrintChar
    case ',' => GetChar
    case '[' => JumpZero
    case ']' => JumpBack
  }
}
