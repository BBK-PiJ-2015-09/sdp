package vendor

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVendorParserSuite extends FunSuite {
  val vp = VirtualMachineFactory.vendorParser

  test("[3] vendor parser should parse a program string correctly") {
    val insts = vp.parseString("iconst 4\niconst 5\niadd\nprint")

    assert(insts.length == 4)

    assert(insts(0).name == "iconst")
    assert(insts(0).args == Vector(4))
    assert(insts(1).name == "iconst")
    assert(insts(1).args == Vector(5))
    assert(insts(2).name == "iadd")
    assert(insts(2).args == Vector())
    assert(insts(3).name == "print")
    assert(insts(3).args == Vector())
  }

  test("[4] vendor parser should parse a program file correctly") {
    val insts = vp.parse("programs/p03.vm")
    assert(insts.length == 20)

    val all = Vector("iconst", "iconst", "iswap", "iadd", "iconst", "iadd",
      "iconst", "isub", "iconst", "imul", "iconst", "idiv",
      "iconst", "irem", "ineg", "idec", "iinc", "idup", "print", "print")
    for (i <- insts.indices) {
      assert(insts(i).name == all(i))
    }
  }
}
