package counter

import org.scalatest.{BeforeAndAfter, FunSuite}

class CounterTest extends FunSuite with BeforeAndAfter {

  var counter: Counter = _

  before {
    counter = new Counter(1)
  }

  test("inc") {
    assert(counter.inc.count === 2)
  }

  test("dec") {
    assert(counter.dec.count === 0)
  }

}
