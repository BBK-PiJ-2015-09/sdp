package counter

import org.scalatest.{BeforeAndAfter, FunSuite}

class AdderTest extends FunSuite with BeforeAndAfter {

  var adder: Adder = _

  before {
    adder = new Adder(1)
  }

  test("add") {
    assert(adder.add(1).count === 2)
  }

}
