package com.jacekduszenko

import com.jacekduszenko.interpreter.impl.BrainfuckInterpreterImpl
import com.jacekduszenko.loader.{CodeLoader, FileCodeLoaderType}


object Main {
  val correctNumberOfArgs = 1
  val usageErrorMessage = "USAGE: scala Main BRAINFUCK_FILE"
  val contentsUnavailableMessage = "contents unavailable, exiting..."

  def main(args: Array[String]): Unit = {
    assert(isArgsNumberCorrect(args), usageErrorMessage)
    val filename = args.head
    val codeLoader: Option[CodeLoader] = CodeLoader.create(FileCodeLoaderType)
    val code = loadCode(filename, codeLoader)
    BrainfuckInterpreterImpl(code).interpret()
  }

  private def loadCode(filename: String, codeLoader: Option[CodeLoader]): String = {
    codeLoader match {
      case Some(loader) => loader.loadCode(filename)
      case None => abortWithError(usageErrorMessage)
    }
  }

  private def abortWithError(msg: String): String = {
    println(msg)
    System.exit(1)
    """ERROR"""
  }

  private def isArgsNumberCorrect(args: Array[String]): Boolean = args.length == correctNumberOfArgs
}
