package counter

case class Counter(count: Int = 0) {
  def inc(delta: Int = 1) = { new Counter(count + delta) }
  def dec(delta: Int = 1) = { new Counter(count - delta) }
  def adjust(adder: Adder) = { new Counter(adder.add(count)) }
}
