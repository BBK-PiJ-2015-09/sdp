package vendor

import scala.io.Source

class ProgramParserImpl extends ProgramParser {
  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String) : InstructionList = {
    toVector(Source.fromString(string))
  }

  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String) : InstructionList = {
    toVector(Source.fromFile(file))
  }

  private def toVector(source: Source) : InstructionList = {
    Vector[Instruction]() ++ toIterator(source)
  }

  private def toIterator(source: Source) : Iterator[Instruction] = {
    source.getLines().map(line => toInstruction(line.split(" ")))
  }

  private def toInstruction(line: Array[String]) : Instruction = {
    new Instruction(line(0), if (line.length > 1) Vector(line(1).toInt) else Vector())
  }

}
