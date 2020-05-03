package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.interpreter.impl.BrainfuckInterpreterImpl.{defaultMemorySize, zeroByte}
import com.jacekduszenko.model.{BrainfuckToken, JumpBack, JumpZero}

object BrainfuckInterpreterImpl {
  private val defaultMemorySize = 30000
  private val zero: Int = 0
  private val zeroByte: Byte = zero.toByte
}

case class BrainfuckInterpreterImpl(memorySize: Int = defaultMemorySize) extends BrainfuckInterpreter {
  private var runtimeState: RuntimeState = (zeroFilledMemory, 0)

  private def zeroFilledMemory: InterpreterMemory = List.fill(memorySize)(zeroByte)

  override def interpret(code: String): Unit = {
    val tokens: List[BrainfuckToken] = fromString(code)
    interpretTokens(tokens)
  }

  def interpretTokens(tokens: List[BrainfuckToken]): Unit = {
    for (i <- tokens.indices) {
      interpretToken(tokens, i)
    }
  }

  private def interpretToken(tokens: List[BrainfuckToken], i: PointerPosition): Unit = {
    if (isLoopStart(tokens, i))
      executeLoop(tokens, i)
    else runtimeState = tokens(i).makeAction(i, tokens, runtimeState)
  }

  private def isLoopStart(tokens: List[BrainfuckToken], i: PointerPosition) = tokens(i) == JumpZero

  private def executeLoop(tokens: List[BrainfuckToken], i: PointerPosition): Unit = {
    while (getValueAtCurrentPosition != 0)
      interpretTokens(findLoopCode(i, tokens))
  }

  private def getValueAtCurrentPosition = {
    runtimeState._1(runtimeState._2)
  }

  def findLoopCode(i: PointerPosition, tokens: List[BrainfuckToken]): List[BrainfuckToken] = {
    tokens.drop(i + 1).takeWhile(tkn => tkn != JumpBack)
  }
}

