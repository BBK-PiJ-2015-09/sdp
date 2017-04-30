package bc

import factory.VirtualMachineFactory

class ByteCodeParserImpl extends ByteCodeParser {
  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a corresponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]) : Vector[ByteCode] = {
    val bcf = VirtualMachineFactory.byteCodeFactory
    var byteCodeVector = Vector[ByteCode]()

    var argument = false

    for (code <- bc) {
      if (argument) {
        byteCodeVector = byteCodeVector :+ bcf.make(bytecode("iconst"), code)
        argument = false
      } else if(code == bytecode("iconst")) {
        argument = true
      } else {
        byteCodeVector = byteCodeVector :+ bcf.make(code)
      }
    }

    byteCodeVector
  }
}
