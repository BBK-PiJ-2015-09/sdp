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
    Vector[Instruction]() ++ string.split("\n").map(line => instruction(line.split(" ")))
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

  private def instruction(line: Array[String]) : Instruction = {
    new Instruction(line(0), if (line.length > 1) Vector(line(1).toInt) else Vector())
  }
}
