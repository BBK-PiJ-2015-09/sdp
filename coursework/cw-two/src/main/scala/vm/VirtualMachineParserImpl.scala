package vm

import scala.collection.mutable.ListBuffer
import scala.io.Source
import bc.{ByteCode, ByteCodeValues}
import factory.VirtualMachineFactory
import vendor.Instruction

/**
  * [[VirtualMachineParserImpl]] defines an implementation of [[VirtualMachineParser]].
  */
class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {
  /**
  * Returns a vector of [[bc.ByteCode]].
  *
  * This method parses a string into a vector of bytecode objects.
  * Note, this method should throw a [[bc.InvalidBytecodeException]]
  * if it fails to parse a program string correctly.
  *
  * @param str a string containing a program
  * @return a vector of bytecodes
  */
  override def parseString(str: String) : Vector[ByteCode] = {
    try {
      toBytecodes(VirtualMachineFactory.vendorParser.parseString(str))
    } catch {
      case _: vendor.InvalidInstructionFormatException => throw new bc.InvalidBytecodeException("Invalid Bytecode!")
      case _: NoSuchElementException => throw new bc.InvalidBytecodeException("Invalid Bytecode!")
    }
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String) = {
    parseString(Source.fromFile(file).mkString)
  }

  /**
    * Parses a vector of Instructions
    * into a vector of ByteCodes.
    *
    * @param instructions the instructions to parse
    * @return a vector of bytecodes
    */
  private def toBytecodes(instructions: Vector[Instruction]) : Vector[ByteCode] = {
    var bytelist = new ListBuffer[Byte]()

    for (i <- instructions) {
      bytelist += bytecode(i.name)
      if (i.name == "iconst") i.args.map(arg => bytelist += arg.asInstanceOf[Byte])
    }

    VirtualMachineFactory.byteCodeParser.parse(bytelist.toVector)
  }
}

