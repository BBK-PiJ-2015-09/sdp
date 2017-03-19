package bc

import vm.VirtualMachine

/**
  * Created by harrywright on 19/03/2017.
  */
class Iconst(arg: Int) extends ByteCode {
  override val code = bytecode("iconst")
  override def execute(vm: VirtualMachine) = vm.push(arg)
}

class Iadd extends ByteCode {
  override val code = bytecode("iadd")
  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x + y)
  }
}

class Isub extends ByteCode {
  override val code: Byte = bytecode("isub")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x - y)
  }
}

class Imul extends ByteCode {
  override val code: Byte = bytecode("imul")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x * y)
  }
}

class Idiv extends ByteCode {
  override val code: Byte = bytecode("idiv")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x / y)
  }
}

class Irem extends ByteCode {
  override val code: Byte = bytecode("irem")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x % y)
  }
}

class Ineg extends ByteCode {
  override val code: Byte = bytecode("ineg")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    vm.push(-x)
  }
}

class Iinc extends ByteCode {
  override val code: Byte = bytecode("iinc")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    vm.push(x + 1)
  }
}

class Idec extends ByteCode {
  override val code: Byte = bytecode("idec")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    vm.push(x - 1)
  }
}

class Iswap extends ByteCode {
  override val code: Byte = bytecode("iswap")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop._1
    val y = vm.pop._1
    vm.push(x)
    vm.push(y)
  }
}

class Print extends ByteCode {
  override val code: Byte = bytecode("print")

  override def execute(vm: VirtualMachine) = {
    val x = vm.pop
    println(x._1)
    x._2
  }
}