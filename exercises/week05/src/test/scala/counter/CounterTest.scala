package counter

import org.scalatest.FunSuite

class CounterTest extends FunSuite {

  var counter: Counter = _

  before {
    counter = new Counter(1)
  }

  test("inc") {
    assert(counter.inc.count === 2)
  }

}
