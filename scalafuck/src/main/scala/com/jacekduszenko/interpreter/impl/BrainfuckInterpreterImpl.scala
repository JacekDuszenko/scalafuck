package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.interpreter.impl.BrainfuckInterpreterImpl.zeroByte
import com.jacekduszenko.model.BrainfuckToken

object BrainfuckInterpreterImpl {
  private val zero: Int = 0
  private val zeroByte: Byte = zero.toByte
}

case class BrainfuckInterpreterImpl(memorySize: Int) extends BrainfuckInterpreter {
  private val runtimeState: RuntimeState = (zeroFilledMemory, 0)

  private def zeroFilledMemory: InterpreterMemory = List.fill(memorySize)(zeroByte)

  override def interpret(code: String): Unit = {
    val tokens: List[BrainfuckToken] = fromString(code)
    for (i <- tokens.indices) {
      nextRuntimeState = tokens(i).makeAction(i, tokens, runtimeState)
    }
  }

}

