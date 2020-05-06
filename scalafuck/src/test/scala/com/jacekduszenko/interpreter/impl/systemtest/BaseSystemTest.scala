package com.jacekduszenko.interpreter.impl.systemtest

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.interpreter.impl.BrainfuckInterpreterImpl
import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.{BeforeAndAfterEach, FunSpec, FunSuite}

abstract class BaseSystemTest extends FunSpec with BeforeAndAfterEach with TimeLimitedTests {
  protected val interpreter: BrainfuckInterpreter = BrainfuckInterpreterImpl()
}
