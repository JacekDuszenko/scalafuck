package com.jacekduszenko.loader

sealed trait CodeLoaderType {
  def equals(that: Any): Boolean = that == this
}

case object FileCodeLoaderType extends CodeLoaderType

case object NetworkCodeLoaderType extends CodeLoaderType