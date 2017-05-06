package decorator

class RomaTomatoes(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Roma Tomatoes (" + price + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + price
  }

  private def price: Double = {
    5.20
  }
}
