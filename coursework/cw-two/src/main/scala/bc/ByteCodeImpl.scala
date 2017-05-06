package bc

import vm.VirtualMachine

/**
  * Represents the Iconst instruction which pushes an
  * Int onto the stack
  *
  * @param arg Int which should be pushed onto the stack
  */
class Iconst(arg: Int) extends ByteCode {
  override val code = bytecode("iconst")
  override def execute(vm: VirtualMachine) = vm.push(arg)
}

/**
  * Represents the Iadd instruction which pops two values off
  * the stack, adds them, then pushes the result
  */
class Iadd extends ByteCode {
  override val code = bytecode("iadd")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 + vm.pop._1)
}

/**
  * Represents the Isub instruction which pops two values off
  * the stack, subtracts one from the other, then pushes the result
  */
class Isub extends ByteCode {
  override val code: Byte = bytecode("isub")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 - vm.pop._1)
}

/**
  * Represents the Imul instruction which pops two values off
  * the stack, calculates the product, then pushes the result
  */
class Imul extends ByteCode {
  override val code: Byte = bytecode("imul")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 * vm.pop._1)
}

/**
  * Represents the Idiv instruction which pops two values off
  * the stack, divides one with the other, then pushes the result
  */
class Idiv extends ByteCode {
  override val code: Byte = bytecode("idiv")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 / vm.pop._1)
}

/**
  * Represents the Irem instruction which pops two values off
  * the stack, calculates the modulus, then pushes the result
  */
class Irem extends ByteCode {
  override val code: Byte = bytecode("irem")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 % vm.pop._1)
}

/**
  * Represents the Ineg instruction which pops one value off
  * the stack, negates it, then pushes the result
  */
class Ineg extends ByteCode {
  override val code: Byte = bytecode("ineg")
  override def execute(vm: VirtualMachine) = vm.push(-vm.pop._1)
}

/**
  * Represents the Iinc instruction which pops one value off
  * the stack, increments it by 1, then pushes the result
  */
class Iinc extends ByteCode {
  override val code: Byte = bytecode("iinc")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 + 1)
}

/**
  * Represents the Idec instruction which pops one value off
  * the stack, decrements it by 1, then pushes the result
  */
class Idec extends ByteCode {
  override val code: Byte = bytecode("idec")
  override def execute(vm: VirtualMachine) = vm.push(vm.pop._1 - 1)
}

/**
  * Represents the Iswap instruction which pops two values off
  * the stack, then pushes them both back in the reverse order
  */
class Iswap extends ByteCode {
  override val code: Byte = bytecode("iswap")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x)
    vm.push(y)
  }
}

/**
  * Represents the Idup instruction which pops one value off
  * the stack, then pushes it back twice
  */
class Idup extends ByteCode {
  override val code: Byte = bytecode("idup")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    vm.push(x)
    vm.push(x)
  }
}

/**
  * Represents the Print instruction which pops one value off
  * the stack, then prints it (without pushing it back)
  */
class Print extends ByteCode {
  override val code: Byte = bytecode("print")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop
    println(x._1)
    x._2
  }
}