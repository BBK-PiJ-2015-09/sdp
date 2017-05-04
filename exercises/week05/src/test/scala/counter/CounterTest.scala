package counter

import org.scalatest.{BeforeAndAfter, FunSuite}

class CounterTest extends FunSuite with BeforeAndAfter {

  var counter: Counter = _

  before {
    counter = new Counter(1)
  }

  test("inc") {
    assert(counter.inc().count === 2)
  }

  test("inc by 2") {
    assert(counter.inc(2).count === 3)
  }

  test("dec") {
    assert(counter.dec().count === 0)
  }

  test("dec by 2") {
    assert(counter.dec(2).count === -1)
  }

  test("adjust") {
    assert(counter.adjust(new Adder(1)).count === 2)
  }

}
