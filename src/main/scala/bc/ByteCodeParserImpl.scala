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
    import scala.collection.mutable.ListBuffer
    var byteCodeList = new ListBuffer[ByteCode]()

    var iconst = false

    for (code <- bc) {
      if (iconst) {
        byteCodeList += bcf.make(bytecode("iconst"), code)
        iconst = false
      } else {
        if(code != bytecode("iconst")) {
          byteCodeList += bcf.make(code)
        } else {
          iconst = true
        }
      }
    }
    byteCodeList.toVector
  }
}
