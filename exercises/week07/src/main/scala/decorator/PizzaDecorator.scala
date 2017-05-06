package decorator

public abstract class PizzaDecorator extends Pizza {
  abstract def getDesc: String

  abstract def getPrice: Double
}
