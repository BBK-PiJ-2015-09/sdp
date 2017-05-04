package counter

case class Counter(_count: Int = 0) {
  def count = { _count }
  def inc(delta: Int = 1) = { new Counter(count + delta) }
  def dec(delta: Int = 1) = { new Counter(count - delta) }
  def adjust(adder: Adder) = { new Counter(adder.add(count)) }
}
