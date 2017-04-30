package vm

import bc.{ByteCode, Iadd}
import factory.VirtualMachineFactory

class VirtualMachineParserImpl extends VirtualMachineParser {/**
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
    val instructions = VirtualMachineFactory.vendorParser.parseString(str)

    import scala.collection.mutable.ListBuffer
    var bytelist = new ListBuffer[Byte]()

    // Refactor this
    val bytecode = new Iadd().bytecode

    // use ByteCodeValues to turn instruction into a byte
    for (i <- instructions) {
      if (i.name == "iconst") {
        bytelist += bytecode(i.name)
        for (arg <- i.args) {
          bytelist += arg.asInstanceOf[Byte]
        }
      } else {
        try {
          bytelist += bytecode(i.name)
        } catch {
          case exc: NoSuchElementException => throw new bc.InvalidBytecodeException("Invalid Bytecode!")
        }
      }
    }

    VirtualMachineFactory.byteCodeParser.parse(bytelist.toVector)
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
