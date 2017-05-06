package decorator

class RomaTomatoes(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    "Roma Tomatoes"
  }

  def getPrice: Double = {
    5.20
  }
}
