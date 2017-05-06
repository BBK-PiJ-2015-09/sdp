package decorator

class SimplyNonVegPizza extends Pizza {
  def getDesc: String = {
    "SimplyNonVegPizza"
  }

  def getPrice: Double = {
    350.00
  }
}
