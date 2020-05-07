package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.model.exception.WrongSyntaxException
import com.jacekduszenko.model.{JumpBack, JumpDirection, JumpForward, Runtime}

class BrainfuckInterpreterImpl extends BrainfuckInterpreter {

  val state: Runtime = new Runtime()
  private var programCounter: Int = 0

  override def interpret(code: String): Unit = {
    while (programCounter < code.length) {
      code.charAt(programCounter) match {
        case '>' => state.movePointerToTheRight()
        case '<' => state.movePointerToTheLeft()
        case '+' => state.increasePointerValue()
        case '-' => state.decreasePointerValue()
        case '.' => state.outputByteAtPointer()
        case ',' => state.inputByteAtPointer()
        case '[' => if (state.isValueAtPointerZero) jump(JumpForward, code)
        case ']' => jump(JumpBack, code)
        case _ => throw new WrongSyntaxException()
      }
      programCounter += 1
      println(programCounter)
    }
  }

  private def jump(direction: JumpDirection, code: String): Unit = {
    val directionValue: Int = determineJumpDirection(direction)
    var parenCtr: Int = 1
    while (parenCtr > 0) {
      programCounter += directionValue
      parenCtr += (code.charAt(programCounter) match {
        case '[' => directionValue
        case ']' => -directionValue
        case _ => 0
      })
    }
  }

  private def determineJumpDirection(direction: JumpDirection): Int = {
    direction match {
      case JumpForward => 1
      case JumpBack => -1
    }
  }
}