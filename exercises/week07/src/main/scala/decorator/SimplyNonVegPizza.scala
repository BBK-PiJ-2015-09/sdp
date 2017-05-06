package decorator

class SimplyNonVegPizza extends Pizza {
  def getDesc: String = {
    "SimplyNonVegPizza (" + getPrice + ")"
  }

  def getPrice: Double = {
    350.00
  }
}
