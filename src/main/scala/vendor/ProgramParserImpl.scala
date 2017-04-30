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
    val input_array = string.split("\n") // Split string on newline
    var output_array = new Array[Instruction](input_array.length)

    for (i <- 0 until input_array.length) {
      val item = input_array(i)
      val split = item.split(" ")
      if (split.length == 2) {
        output_array(i) = new Instruction(split(0), Vector(split(1).toInt))
      } else {
        output_array(i) = new Instruction(split(0), Vector())
      }
    }

    output_array.to[Vector]
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
