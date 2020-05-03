package com.jacekduszenko.model

import com.jacekduszenko.interpreter.impl.RuntimeState

import scala.io.StdIn

sealed trait BrainfuckToken {
  def makeAction(tokenIndex: Int, tokens: List[BrainfuckToken], state: RuntimeState): RuntimeState
}

case object IncrementPointer extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = (state._1, state._2 + 1)
}

case object DecrementPointer extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = (state._1, state._2 - 1)

}

case object IncrementValue extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = {
    val updatedMemory = state._1.updated(state._2, (state._1(state._2) + 1).toByte)
    (updatedMemory, state._2)
  }
}

case object DecrementValue extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = {
    val updatedMemory = state._1.updated(state._2, (state._1(state._2) - 1).toByte)
    (updatedMemory, state._2)
  }
}

case object PrintChar extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = {
    print(state._1(state._2).toChar)
    state
  }
}

case object GetChar extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = {
    val letter: Byte = StdIn.readLine().toByte
    val updatedMemory = state._1.updated(state._2, letter)
    (updatedMemory, state._2)
  }
}

case object JumpZero extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = {
    state
  }
}

case object JumpBack extends BrainfuckToken {
  override def makeAction(tokenIndex: Int, tokens: scala.List[BrainfuckToken], state: RuntimeState): RuntimeState = {
    state
  }
}