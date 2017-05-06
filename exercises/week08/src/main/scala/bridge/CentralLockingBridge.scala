package bridge

object CentralLockingBridge {

  def assemble(product: Product, s: String): Unit = {
    println("Modifying " + product.productName + " according to " + s)
    println("Assembling " + product.productName + " for " + s)
  }

}
