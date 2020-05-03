package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.model._
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class BrainfuckInterpreterImplTest extends FunSuite with BeforeAndAfterEach with BrainfuckInterpreter {

  var brainfuckInterpreterImpl: BrainfuckInterpreterImpl = BrainfuckInterpreterImpl()

  test("Should find valid length of loop fragment in list of instructions") {
    //given
    val loopZeroIndex = 4
    val loopCode = brainfuckInterpreterImpl.findLoopCode(loopZeroIndex, createTestList)

    //then
    loopCode.foreach(token => assert(token == IncrementPointer))
    assert(loopCode.size == 3)
  }

  test("Should create valid tokens from string input") {
    val exampleStringInput = "<<<....>>>"
    val result = fromString(exampleStringInput)
    result.take(3).foreach(tkn => assert(tkn == DecrementPointer))
    result.slice(3, 7).foreach(tkn => assert(tkn == PrintChar))
    result.slice(7, 10).foreach(tkn => assert(tkn == IncrementPointer))
  }

  private def createTestList: List[BrainfuckToken] = {
    List(IncrementPointer, IncrementPointer, IncrementPointer, IncrementPointer, JumpZero, IncrementPointer, IncrementPointer, IncrementPointer, JumpBack)
  }

  override def interpret(code: String): Unit = ???
}
