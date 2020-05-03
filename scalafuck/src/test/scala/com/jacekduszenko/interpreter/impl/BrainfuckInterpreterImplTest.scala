package com.jacekduszenko.interpreter.impl

import com.jacekduszenko.model.{BrainfuckToken, IncrementPointer, JumpBack, JumpZero}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class BrainfuckInterpreterImplTest extends FunSuite with BeforeAndAfterEach {

  var brainfuckInterpreterImpl: BrainfuckInterpreterImpl = BrainfuckInterpreterImpl()

  override def beforeEach() {

  }

  override def afterEach() {

  }

  test("Should find valid length of loop fragment in list of instructions") {
    val loopZeroIndex = 4
    val loopCode = brainfuckInterpreterImpl.findLoopCode(loopZeroIndex, createTestList)

    loopCode.foreach(token => assert(token == IncrementPointer))
    assert(loopCode.size == 3)
  }

  private def createTestList: List[BrainfuckToken] = {
    List(IncrementPointer, IncrementPointer, IncrementPointer, IncrementPointer, JumpZero, IncrementPointer, IncrementPointer, IncrementPointer, JumpBack)
  }
}
