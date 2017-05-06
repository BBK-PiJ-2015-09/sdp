package bridge

case class Motoren(product: Product, s: String) extends Car(product, s) {
  override def assemble: Unit = product.productName match {
      case "Central Locking System" => CentralLockingBridge.assemble(product, s)
      case "Gear Locking System" => GearLockingBridge.assemble(product, s)
  }

  override def produceProduct: Unit = {
    product.produce
  }

  override def printDetails: Unit = {
    println("Car: " + s + ", Product:" + product.productName)
  }
}
