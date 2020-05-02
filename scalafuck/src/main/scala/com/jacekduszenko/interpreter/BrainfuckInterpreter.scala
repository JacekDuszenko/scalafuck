package com.jacekduszenko.interpreter

trait BrainfuckInterpreter {
  def initializeMemory(): Unit

  def interpretCode(code: String): Unit
}
