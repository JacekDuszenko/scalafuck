package com.jacekduszenko

import com.jacekduszenko.interpreter.impl.BrainfuckInterpreterImpl
import com.jacekduszenko.loader.{CodeLoader, FileCodeLoaderType}
import com.jacekduszenko.model.exception.WrongUsageException

import scala.util.{Failure, Success, Try}


object Main {
  val correctNumberOfArgs = 1
  val usageErrorMessage = "USAGE: scala Main BRAINFUCK_FILE"
  val contentsUnavailableMessage = "contents unavailable, exiting..."
  val runtimeErrorMessage = "Interpreter failed with error"

  def main(args: Array[String]): Unit = {
    assert(isArgsNumberCorrect(args), usageErrorMessage)

    val filename = args.head
    val interpreter = new BrainfuckInterpreterImpl

    loadCode(filename, CodeLoader.create(FileCodeLoaderType)) match {
      case Success(tokens) => Try(interpreter.interpret(tokens))
      case Failure(e) => abortWithError(e.getMessage)
    }
  }

  private def loadCode(filename: String, codeLoader: Option[CodeLoader]): Try[String] = {
    codeLoader match {
      case Some(loader) => Success(loader.loadCode(filename))
      case None => Failure(new WrongUsageException)
    }
  }

  private def abortWithError(msg: String): Unit = {
    println(msg)
    System.exit(1)
  }

  private def isArgsNumberCorrect(args: Array[String]): Boolean = args.length == correctNumberOfArgs
}
