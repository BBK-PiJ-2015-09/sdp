package bridge

case class GearLocking(s: String) extends Product {

  override def productName: String = { "Gear Locking System" }

  override def produce: Unit = { println("Producing " + productName) }
}
