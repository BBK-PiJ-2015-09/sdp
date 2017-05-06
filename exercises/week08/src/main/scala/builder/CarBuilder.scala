package builder

trait CarBuilder {
  def buildBodyStyle : String

  def buildPower : String

  def buildEngine : String

  def buildBrakes : String

  def buildSeats : String

  def buildWindows : String

  def buildFuelType : String

  def getCar : String
}