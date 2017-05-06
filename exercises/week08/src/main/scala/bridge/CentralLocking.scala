package bridge

case class CentralLocking(s: String) extends Product {

  override def productName: String = { "Central Locking System" }

  override def produce: Unit = { println("Producing " + productName) }
}


