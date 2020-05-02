package com.jacekduszenko.loader

import com.jacekduszenko.loader.impl.file.FileCodeLoader
import com.jacekduszenko.loader.impl.network.NetworkCodeLoader

trait CodeLoader {
  def loadCode(a: String): String
}

object CodeLoader {
  def create(t: CodeLoaderType): Option[CodeLoader] = t match {
    case FileCodeLoaderType => Some(new FileCodeLoader())
    case NetworkCodeLoaderType => Some(new NetworkCodeLoader())
    case _ => None
  }
}
