package com.jacekduszenko.interpreter

package object impl {

  type InterpreterMemory = List[Byte]
  type PointerPosition = Int
  type RuntimeState = (InterpreterMemory, PointerPosition)
}
