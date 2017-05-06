package decorator

class GreenOlives(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    "Green Olives"
  }

  def getPrice: Double = {
    5.47
  }
}
