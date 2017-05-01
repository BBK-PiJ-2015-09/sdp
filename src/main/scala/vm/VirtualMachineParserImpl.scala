package vm

import scala.collection.mutable.ListBuffer
import bc.{ByteCode, ByteCodeValues}
import factory.VirtualMachineFactory

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
      val instructions = VirtualMachineFactory.vendorParser.parseString(str)
      var bytelist = new ListBuffer[Byte]()

      // use ByteCodeValues to turn instruction into a byte
      for (i <- instructions) {
        bytelist += bytecode(i.name)
        if (i.name == "iconst") i.args.map(arg => bytelist += arg.asInstanceOf[Byte])
      }

      VirtualMachineFactory.byteCodeParser.parse(bytelist.toVector)
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
    import scala.io.Source

    var concatenated = ""
    for (line <- Source.fromFile(file).getLines()) {
      concatenated = concatenated + "\n" + line
    }
    concatenated = concatenated.substring(1)
    parseString(concatenated)
  }
}
