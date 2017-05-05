package factory

trait Creator {
  def factory(klass: AnyRef) : Product
}
