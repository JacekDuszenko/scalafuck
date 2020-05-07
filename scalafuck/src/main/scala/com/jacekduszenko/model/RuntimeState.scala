package com.jacekduszenko.model

import com.jacekduszenko.model.RuntimeState.{defaultMemorySize, zero, zeroByte}
import com.jacekduszenko.model.model.InterpreterMemory


object RuntimeState {
  private val defaultMemorySize = 30000
  private val zero: Int = 0
  private val zeroByte: Byte = zero.toByte
}

class RuntimeState(private var pointerPosition: Int = zero, val memorySize: Int = defaultMemorySize) {
  val memory: InterpreterMemory = List.fill(memorySize)(zeroByte)

  def movePointerToTheLeft(): Unit = {
    pointerPosition -= 1
  }

  def movePointerToTheRight(): Unit = {
    pointerPosition -= 1
  }

  def increasePointerValue(): Unit = {
    memory.updated(pointerPosition, memory(pointerPosition) + 1)
  }

  def decreasePointerValue(): Unit = {
    memory.updated(pointerPosition, memory(pointerPosition) - 1)
  }
}
