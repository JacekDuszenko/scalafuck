package com.jacekduszenko.model

sealed trait JumpDirection

case object JumpForward extends JumpDirection

case object JumpBack extends JumpDirection