package factory

class ConcreteCreator extends Creator {
  override def factory(klass: AnyRef) : Product = klass match {
    case _ => new ConcreteProduct()
  }
}
