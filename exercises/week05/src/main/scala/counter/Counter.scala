package counter

class Counter(_count: Int) {
  def count = { _count }
  def inc(delta: Int = 1) = { new Counter(count + delta) }
  def dec(delta: Int = 1) = { new Counter(count - delta) }
}
