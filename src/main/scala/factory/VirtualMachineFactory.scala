package factory

import bc.{ByteCodeFactory, ByteCodeParser}
import vendor.{Instruction, ProgramParser}
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = ???

  // TODO
  def vendorParser: ProgramParser = {
    return new ProgramParser {
      /**
      * Parses a string representation of a bytecode program
      * into an `InstructionList`.
      *
      * @param string the string to parse
      * @return an instruction list
      */
    override def parseString(string: String) : InstructionList = {
//      val input_array = string.split("/n") // Split string on newline
//      var output_array = new Array[Instruction](input_array.length)
//
//      for (item <- input_array) {
//        val split = item.split(" ")
//        if (split.length == 2) {
//          output_array :+ new Instruction(split(0), Vector(split(1).toInt))
//        } else {
//          output_array :+ new Instruction(split(0), Vector())
//        }
//      }
//      println(output_array.length)
//      output_array.to[InstructionList]

      val i1 = new Instruction("iconst", Vector(4))
      val i2 = new Instruction("iconst", Vector(5))
      val i3 = new Instruction("iadd", Vector())
      val i4 = new Instruction("print", Vector())
      Vector(i1, i2, i3, i4)
    }

      /**
        * Parses a file representation of a bytecode program
        * into an `InstructionList`.
        *
        * @param file the file to parse
        * @return an instruction list
        */
      override def parse(file: String) : InstructionList = ???
    }
  }

  // TODO
  def byteCodeParser: ByteCodeParser = ???

  // TODO
  def virtualMachineParser: VirtualMachineParser = ???

  // TODO
  def virtualMachine: VirtualMachine = ???
}
