package com.jacekduszenko.interpreter.impl

import org.scalatest.concurrent.Signaler

class ThreadKiller extends Signaler {
  override def apply(testThread: Thread): Unit = {
    testThread.stop()
  }
}
