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
    val lines = string.split("\n")
    var output = Vector[Instruction]()

    for (line <- lines) {
      val split = line.split(" ")
      if (split.length == 2) {
        output = output :+ new Instruction(split(0), Vector(split(1).toInt))
      } else {
        output = output :+ new Instruction(split(0), Vector())
      }
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
