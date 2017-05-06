package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator {
  def getDesc: String = {
    "Ham"
  }

  def getPrice: Double = {
    18.12
  }
}
