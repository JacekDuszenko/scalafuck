package com.jacekduszenko.interpreter

import com.jacekduszenko.model.BrainfuckToken

trait BrainfuckInterpreter {
  def initializeMemory(): Unit

  def interpret(): Unit

  def fromString(code: String): List[BrainfuckToken] = (code toList).map {
    case
  }
}
