package com.jacekduszenko

import com.jacekduszenko.loader.CodeLoader

object Main {
  val correctNumberOfArgs = 1
  val usageErrorMessage = "USAGE: scala Main BRAINFUCK_FILE"

  def main(args: Array[String]): Unit = {
    assert(isArgsNumberCorrect(args), usageErrorMessage)
    val filename = args.head
    val codeLoader: CodeLoader[String] = FileCodeLoader()
    //    val fileContents =

  }


  private def isArgsNumberCorrect(args: Array[String]): Boolean = args.length == correctNumberOfArgs

}
