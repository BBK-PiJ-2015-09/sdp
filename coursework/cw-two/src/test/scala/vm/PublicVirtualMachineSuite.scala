package vm

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVirtualMachineSuite extends FunSuite {
  val vmp = VirtualMachineFactory.virtualMachineParser
  val bcp = VirtualMachineFactory.byteCodeParser
  val vm  = VirtualMachineFactory.virtualMachine

  test("[10] a virtual machine should execute a program") {
    val bc  = vmp.parse("programs/p05.vm")
    val vm2 = vm.execute(bc)
  }

  test("a virtual machine should execute a program and end with correct stack") {
    val bc  = vmp.parse("programs/p05.vm")
    var next = vm.executeOne(bc)
    for(i <- 1 to 10) {
      next = vm.executeOne(next._1)
    }
    assert(next._2.state.length == 1)
    assert(next._2.state.head == 21)

    for(i <- 1 to 6) {
      next = vm.executeOne(next._1)
    }

    assert(next._2.state.length == 1)
    assert(next._2.state.head == 4)

    next = vm.executeOne(next._1)
    assert(next._2.state.length == 0)
  }

  test("bad stack program should throw MachineUnderflowException") {
    val bc  = vmp.parse("programs/p02-bad-stack.vm")
    intercept[MachineUnderflowException] {
      val vm2 = vm.execute(bc)
    }
  }

  test("[2] iconst should work correctly") {
    val bc  = vmp.parseString("iconst 1")
    val (bc2, vm2) = vm.executeOne(bc)
    assert(vm2.state.head == 1)
  }

  test("[2] iadd should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }

  test("[2] isub should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nisub")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[2] iswap should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niswap")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 2)
  }

  test("idec should work properly") {
    val bc  = vmp.parseString("iconst 2\nidec\nidec")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 0)
  }

  test("idiv should work properly") {
    val bc  = vmp.parseString("iconst 3\niconst 6\nidiv")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 6)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
  }

  test("idup should work properly") {
    val bc  = vmp.parseString("iconst 20\nidup")
    var next = vm.executeOne(bc)
    assert(next._2.state(1) != 20)
    assert(next._2.state.head == 20)
    next = next._2.executeOne(next._1)
    assert(next._2.state(1) == 20)
    assert(next._2.state.head == 20)
  }

  test("iinc should work properly") {
    val bc  = vmp.parseString("iconst 2\niinc\niinc")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 4)
  }

  test("imul should work properly") {
    val bc  = vmp.parseString("iconst 3\niconst 6\nimul")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 3)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 6)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 18)
  }

  test("ineg should work properly") {
    var bc = vmp.parseString("iconst 12\nineg\nineg")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 12)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == -12)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 12)
  }

  test("irem should work properly when remainder") {
    val bc  = vmp.parseString("iconst 2\niconst 5\nirem")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("irem should work properly when no remainder") {
    val bc  = vmp.parseString("iconst 2\niconst 100\nirem")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 100)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 0)
  }
}
