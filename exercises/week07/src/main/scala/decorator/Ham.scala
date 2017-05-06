package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator {
  def getDesc: String = {
    pizza.getDesc + ", Ham (" + price + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + price
  }

  private def price: Double = {
    18.12
  }
}
