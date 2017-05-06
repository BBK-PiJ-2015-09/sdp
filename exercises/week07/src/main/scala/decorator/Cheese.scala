package decorator

class Cheese(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Cheese (" + price + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + price
  }

  private def price: Double = {
    20.72
  }
}
