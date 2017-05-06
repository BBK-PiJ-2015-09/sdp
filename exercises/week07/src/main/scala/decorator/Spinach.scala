package decorator

class Spinach(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    "Spinach"
  }

  def getPrice: Double = {
    7.92
  }
}
