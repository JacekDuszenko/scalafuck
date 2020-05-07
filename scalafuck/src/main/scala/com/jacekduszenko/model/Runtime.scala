package com.jacekduszenko.model

import com.jacekduszenko.model.Runtime.{defaultMemorySize, unitByte, zero, zeroByte}
import com.jacekduszenko.model.model.InterpreterMemory

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn


object Runtime {
  private val defaultMemorySize = 30000
  private val zero: Int = 0
  private val zeroByte: Byte = zero.toByte
  private val unitByte: Byte = 1.toByte
}

class Runtime(private var pointerPosition: Int = zero, val memorySize: Int = defaultMemorySize) {

  val memory: InterpreterMemory = ArrayBuffer.fill(memorySize)(zeroByte)

  def movePointerToTheLeft(): Unit = {
    pointerPosition -= 1
  }

  def movePointerToTheRight(): Unit = {
    pointerPosition += 1
  }

  def increasePointerValue(): Unit = {
    memory(pointerPosition) = (memory(pointerPosition) + unitByte).toByte
  }

  def decreasePointerValue(): Unit = {
    memory(pointerPosition) = (memory(pointerPosition) - unitByte).toByte
  }

  def outputByteAtPointer(): Unit = {
    print(memory(pointerPosition).toChar)
  }

  def inputByteAtPointer(): Unit = {
    memory(pointerPosition) = StdIn.readByte()
  }

  def isValueAtPointerZero: Boolean = {
    memory(pointerPosition) == 0
  }

  def isValueAtPointerNonZero: Boolean = {
    !isValueAtPointerZero
  }
}
