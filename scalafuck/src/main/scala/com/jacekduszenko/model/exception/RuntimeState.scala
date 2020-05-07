package com.jacekduszenko.model.exception

import com.jacekduszenko.model.exception.RuntimeState.{defaultMemorySize, zero}
import com.jacekduszenko.model.exception.impl.InterpreterMemory


object RuntimeState {
  private val defaultMemorySize = 30000
  private val zero: Int = 0
  private val zeroByte: Byte = zero.toByte
}

class RuntimeState(val pointerPosition: Int = zero, val memorySize: Int = defaultMemorySize) {

  val memory: InterpreterMemory = List.fill(memorySize, RuntimeState.zeroByte)

}
