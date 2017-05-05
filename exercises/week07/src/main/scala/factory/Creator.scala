package factory

trait Creator {
  def factory(situation: String) : Product
}
