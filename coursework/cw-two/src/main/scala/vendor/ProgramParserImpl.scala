package vendor

import bc.ByteCodeValues

import scala.io.Source

/**
  * [[ProgramParserImpl]] defines an implementation of [[ProgramParser]].
  */
class ProgramParserImpl extends ProgramParser with ByteCodeValues {
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

  /**
    * Parses a source object into an `InstructionList`
    *
    * @param source
    * @return an instruction list
    */
  private def toVector(source: Source) : InstructionList = {
    Vector[Instruction]() ++ toIterator(source)
  }

  /**
    * Parses a source object into an Iterator of Instructions
    *
    * @param source
    * @return an Iterator of Instructions
    */
  private def toIterator(source: Source) : Iterator[Instruction] = {
    source.getLines().map(line => toInstruction(line.split(" ")))
  }

  /**
    * Parses an Array of Strings representing a single instruction
    * with arguments into an Instruction object
    *
    * @param line an array of String objects
    * @return a single Instruction
    */
  private def toInstruction(line: Array[String]) : Instruction = {
    if(!bytecode.contains(line(0))) throw new InvalidInstructionFormatException("Invalid Bytecode!")

    new Instruction(line(0), if (line.length > 1) Vector(line(1).toInt) else Vector())
  }

}
