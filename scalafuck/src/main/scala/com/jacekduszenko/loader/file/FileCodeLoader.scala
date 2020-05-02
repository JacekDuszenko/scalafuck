package com.jacekduszenko.loader.file

import com.jacekduszenko.loader.CodeLoader

import scala.io.Source

class FileCodeLoader extends CodeLoader {
  override def loadCode(filename: String): String = fileAsString(filename)

  private def fileAsString(filename: String): String = {
    val src = Source.fromFile(filename)
    val result = src.getLines().mkString("\n")
    src.close()
    result
  }
}
