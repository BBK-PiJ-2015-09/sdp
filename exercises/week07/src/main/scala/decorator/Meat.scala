package decorator

class Meat(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Meat (" + price + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + price
  }

  private def price: Double = {
    14.25
  }
}
