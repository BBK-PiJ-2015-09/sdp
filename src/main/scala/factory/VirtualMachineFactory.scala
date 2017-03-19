package factory

import bc._
import vendor.{Instruction, ProgramParser}
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = {
    return new ByteCodeFactory {
      /**
        * Returns a [[ByteCode]].
        *
        * This method creates a new [[ByteCode]] object given the `byte`
        * that corresponds to the bytecode (see [[ByteCodeValues]]. If
        * the bytecode requires arguments then an optional integer
        * argument is provided.
        *
        * This method should throw an [[InvalidBytecodeException]] if the
        * given bytecode value is unknown.
        *
        * @param byte the byte code of a bytecode
        * @param args an optional integer argument (depends on bytecode)
        * @return a new bytecode object
        */
      override def make(byte: Byte, args: Int*) : ByteCode = byte match {
        case 1 => new Iconst(args(0))
        case 2 => new Iadd
        case 3 => new Isub
        case 4 => new Imul
        case 5 => new Idiv
        case 6 => new Irem
        case 7 => new Ineg
        case 8 => new Iinc
        case 9 => new Idec
        case 10 => new Idup
        case 11 => new Iswap
        case 12 => new Print
        case _ => throw new InvalidBytecodeException("bytecode incorrect: " + byte)
      }
    }
  }

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
  }

  // TODO
  def byteCodeParser: ByteCodeParser = ???

  // TODO
  def virtualMachineParser: VirtualMachineParser = ???

  // TODO
  def virtualMachine: VirtualMachine = ???
}
