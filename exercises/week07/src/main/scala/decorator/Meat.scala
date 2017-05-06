package decorator

class Meat(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    "Meat"
  }

  def getPrice: Double = {
    14.25
  }
}
