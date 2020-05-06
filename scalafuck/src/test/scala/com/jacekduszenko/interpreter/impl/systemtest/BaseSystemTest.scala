package com.jacekduszenko.interpreter.impl.systemtest

import com.jacekduszenko.interpreter.BrainfuckInterpreter
import com.jacekduszenko.interpreter.impl.{BrainfuckInterpreterImpl, ThreadKiller}
import org.scalatest.concurrent.{Signaler, TimeLimitedTests}
import org.scalatest.{BeforeAndAfterEach, FunSpec}

abstract class BaseSystemTest extends FunSpec with BeforeAndAfterEach with TimeLimitedTests {

  override val defaultTestSignaler: Signaler = new ThreadKiller()

  protected val interpreter: BrainfuckInterpreter = BrainfuckInterpreterImpl()
}
