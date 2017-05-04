package counter

class Counter(_count: Int) {
  def count = { _count }
  def inc = { new Counter(count + 1) }
}
