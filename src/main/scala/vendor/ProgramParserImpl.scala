package vendor

class ProgramParserImpl extends ProgramParser {
  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String) : InstructionList = {
    var output = Vector[Instruction]()

    for (line <- string.split("\n")) {
      val split = line.split(" ")
      val code = split(0)
      val argument = if (split.length > 1) Vector(split(1).toInt) else Vector()
      output = output :+ new Instruction(code, argument)
    }

    output
  }

  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String) : InstructionList = {
    import scala.io.Source

    var concatenated = ""
    for (line <- Source.fromFile(file).getLines()) {
      concatenated = concatenated + "\n" + line
    }
    concatenated = concatenated.substring(1)
    parseString(concatenated)
  }
}
