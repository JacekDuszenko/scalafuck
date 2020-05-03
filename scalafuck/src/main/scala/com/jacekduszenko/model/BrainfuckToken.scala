package com.jacekduszenko.model

sealed trait BrainfuckToken {
}

case object IncrementPointer extends BrainfuckToken {
}

case object DecrementPointer extends BrainfuckToken {
}

case object IncrementValue extends BrainfuckToken {
}

case object DecrementValue extends BrainfuckToken {
}

case object PrintChar extends BrainfuckToken {
}

case object GetChar extends BrainfuckToken {
}

case object JumpZero extends BrainfuckToken {
}

case object JumpBack extends BrainfuckToken {
}