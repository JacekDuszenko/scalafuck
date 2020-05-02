import scala.io.Source

object Main {
  val correctNumberOfArgs = 1
  val usageErrorMessage = "USAGE: scala Main BRAINFUCK_FILE"

  def main(args: Array[String]): Unit = {
    assert(isArgsNumberCorrect(args), usageErrorMessage)
    val filename = args.head
    val code = fileAsString(filename)

    println(code)
  }

  private def fileAsString(filename: String): String = {
    val src = Source.fromFile(filename)
    val result = src.getLines().mkString("\n")
    src.close()
    result
  }

  private def isArgsNumberCorrect(args: Array[String]): Boolean = args.length == correctNumberOfArgs

}