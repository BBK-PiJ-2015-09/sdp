package factory

class ConcreteCreator extends Creator {
  override def factory(situation: String) : Product = situation match {
    case "Let's have something different!" => new DifferentProduct()
    case _ => new ConcreteProduct()
  }
}
