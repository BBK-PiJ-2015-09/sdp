package decorator

class Cheese(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    "Cheese"
  }

  def getPrice: Double = {
    20.72
  }
}
