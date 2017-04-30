package factory

import bc.{InvalidBytecodeException, _}
import vendor.{Instruction, ProgramParser}
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = {
    new ByteCodeFactory {
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

  def vendorParser: ProgramParser = {
    new ProgramParser {
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


  def byteCodeParser: ByteCodeParser = {
    new ByteCodeParser {
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
            byteCodeList += bcf.make(1, code)
            iconst = false
          } else {
            if (code != 1) {
              byteCodeList += bcf.make(code)
            } else {
              iconst = true
            }
          }
        }
        byteCodeList.toVector
      }
    }
  }

  // TODO
  def virtualMachineParser: VirtualMachineParser = {
    new VirtualMachineParser {/**
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
      val instructions = vendorParser.parseString(str)

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

      byteCodeParser.parse(bytelist.toVector)
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
  }

  // TODO
  def virtualMachine: VirtualMachine = {
    new VirtualMachine {

      var myStack = Vector[Int]()

      /**
        * Executes a vector of bytecodes.
        *
        * Note, that this is an "immutable" object. That is, it
        * will return a new virtual machine after executing each
        * of the bytecode objects in the vector.
        *
        * @param bc a vector of bytecodes
        * @return a new virtual machine
        */
      override def execute(bc: Vector[ByteCode]): VirtualMachine = {
        var myBC = bc
        for(i <- 1 to bc.length) {
          val pair = executeOne(myBC)
          myBC = pair._1
          myStack = pair._2.state
        }
        this
      }


      /**
        * Executes the next bytecode in the vector of bytecodes.
        *
        * This method only executes a single byte code in the vector of bytecodes.
        * It returns a tuple of the new vector of bytecodes (with the executed
        * bytecode removed) and the new virtual machine.
        *
        * You may assume that `bc` contains at least 1 bytecode.
        *
        * @param bc the vector of bytecodes
        * @return a tuple of a new vector of bytecodes and virtual machine
        */
      override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
        val topBC = bc(0)
        val newBC = bc.drop(1)
        val newVC = topBC.execute(this)
        (newBC,newVC)
      }

      /**
        * Pushes an integer value onto the virtual machine stack.
        *
        * @param value the integer to push
        * @return a new virtual machine with the integer `value` pushed
        */
      override def push(value: Int): VirtualMachine = {
        myStack = myStack.+:(value)
        this
      }

      /**
        * Pops an integer value off of the virtual machine stack.
        *
        * @return (i, vm), where i is the integer popped and vm is the
        *         new virtual machine
        */
      override def pop(): (Int, VirtualMachine) = {
        val myInt = myStack(0)
        myStack = myStack.drop(1)
        (myInt,this)
      }

      /**
        * Returns the state of the virtual machine stack.
        *
        * The value at index 0 is the value on the top of the stack.
        *
        * @return the state of the stack
        */
      override def state: Vector[Int] = {
        myStack
      }
    }
  }
}
