package bc

class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {
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
    case _ if byte equals bytecode("iconst") => new Iconst(args(0))
    case _ if byte equals bytecode("iadd") => new Iadd
    case _ if byte equals bytecode("isub") => new Isub
    case _ if byte equals bytecode("imul") => new Imul
    case _ if byte equals bytecode("idiv") => new Idiv
    case _ if byte equals bytecode("irem") => new Irem
    case _ if byte equals bytecode("ineg") => new Ineg
    case _ if byte equals bytecode("iinc") => new Iinc
    case _ if byte equals bytecode("idec") => new Idec
    case _ if byte equals bytecode("idup") => new Idup
    case _ if byte equals bytecode("iswap") => new Iswap
    case _ if byte equals bytecode("print") => new Print
    case _ => throw new InvalidBytecodeException("bytecode incorrect: " + byte)
  }
}
