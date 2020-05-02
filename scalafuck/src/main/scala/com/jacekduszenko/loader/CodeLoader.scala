package com.jacekduszenko.loader

import com.jacekduszenko.loader.file.FileCodeLoader

trait CodeLoader {

  def loadCode(a: String): String

  def create(t: CodeLoaderType): CodeLoader = t match {
    case FileCodeLoaderType => new FileCodeLoader()
    case NetworkCodeLoaderType => new

  }
}
