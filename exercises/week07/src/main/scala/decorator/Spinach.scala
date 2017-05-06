package decorator

class Spinach(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Spinach (" + price + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + price
  }

  private def price: Double = {
    7.92
  }
}
