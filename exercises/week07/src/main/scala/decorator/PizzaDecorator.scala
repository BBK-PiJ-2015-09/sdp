package decorator

abstract class PizzaDecorator extends Pizza {
  def getDesc: String

  def getPrice: Double
}
