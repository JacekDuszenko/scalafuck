package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.interpreter.impl.BrainfuckInterpreterImpl.{defaultMemorySize, zeroByte}
import com.jacekduszenko.model.{BrainfuckToken, JumpBack, JumpZero}

import scala.collection.mutable.ArrayBuffer

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

  private def interpretToken(tokens: List[BrainfuckToken], tokenIndex: PointerPosition): Unit = {
    if (isTokenALoopStart(tokens, tokenIndex))
      executeLoop(tokens, tokenIndex)
    else updateRuntimeState(tokens, tokenIndex)
  }

  private def updateRuntimeState(tokens: List[BrainfuckToken], tokenIndex: PointerPosition): Unit = {
    runtimeState = tokens(tokenIndex).makeAction(tokenIndex, tokens, runtimeState)
  }

  private def isTokenALoopStart(tokens: List[BrainfuckToken], i: PointerPosition) = tokens(i) == JumpZero

  private def executeLoop(tokens: List[BrainfuckToken], i: PointerPosition): Unit = {
    while (getValueAtCurrentPosition != 0)
      interpretTokens(findLoopCode(i, tokens))
  }

  private def getValueAtCurrentPosition = {
    runtimeState._1(runtimeState._2)
  }

  //TODO refactor to functional => state monad (I know this is ugly, gotta read up more on fp in scala and reimplement)
  def findLoopCode(i: PointerPosition, tokens: List[BrainfuckToken]): List[BrainfuckToken] = {
    var openParenCounter: Int = 0
    val buffer: ArrayBuffer[BrainfuckToken] = ArrayBuffer()
    for (t <- tokens.drop(i + 1)) {
      t match {
        case JumpBack => openParenCounter -= 1
        case JumpZero if openParenCounter == 0 => return buffer.toList
        case JumpZero => openParenCounter += 1; buffer.addOne(t)
        case _ => buffer.addOne(t)
      }
    }
    buffer.toList
  }
}

