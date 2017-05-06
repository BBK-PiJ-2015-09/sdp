package builder

case class CarDirector(carBuilder: CarBuilder) {
  private var car : Car = _

  def build : Car = {
    car = new Car(carBuilder.getCar.toString)
    car.setBodyStyle(carBuilder.buildBodyStyle.toString)
    car.setPower(carBuilder.buildPower.toString)
    car.setEngine(carBuilder.buildEngine.toString)
    car.setBreaks(carBuilder.buildBreaks.toString)
    car.setSeats(carBuilder.buildSeats.toString)
    car.setWindows(carBuilder.buildWindows.toString)
    car.setFuelType(carBuilder.buildFuelType.toString)
    car
  }

  def getCar : Car = {
    car
  }

}
