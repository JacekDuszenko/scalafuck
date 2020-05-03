package com.jacekduszenko.loader

sealed trait CodeLoaderType

case object FileCodeLoaderType extends CodeLoaderType

case object NetworkCodeLoaderType extends CodeLoaderType