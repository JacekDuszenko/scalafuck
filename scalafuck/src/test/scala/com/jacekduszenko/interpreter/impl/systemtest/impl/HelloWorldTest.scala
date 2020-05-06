package com.jacekduszenko.interpreter.impl.systemtest.impl

import com.jacekduszenko.interpreter.impl.systemtest.BaseSystemTest
import com.jacekduszenko.interpreter.impl.systemtest.impl.HelloWorldTest.helloWorldResource
import org.scalatest.time.{Seconds, Span}

import scala.io.Source

object HelloWorldTest {
  private val helloWorldResource = "src/test/resources/helloworld.fuck"
}

class HelloWorldTest extends BaseSystemTest {

  val timeLimit: Span = Span(3, Seconds)

  describe("Hello world interpreting test") {
    it("Should interpret hello world correctly") {
      val helloWorldStringInput = fetchBrainfuckFromFile(helloWorldResource)
      println(helloWorldStringInput)
      interpreter.interpret(helloWorldStringInput)
    }
  }

  private def fetchBrainfuckFromFile(filename: String): String = {
    val src = Source.fromFile(filename)
    val str = src.mkString
    src.close()
    str
  }

}
