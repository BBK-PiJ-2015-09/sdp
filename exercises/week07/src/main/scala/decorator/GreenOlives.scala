package decorator

class GreenOlives(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Green Olives (" + price + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + price
  }

  private def price: Double = {
    5.47
  }
}
