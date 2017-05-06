package builder

object SportsCarBuilder extends CarBuilder {

  override def buildBodyStyle: String = {
    """External dimensions: overall length (inches): 192.3,
    | overall width (inches): 75.5, overall height (inches): 54.2,
    | wheelbase (inches): 112.3, front track (inches): 63.7,
    | rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7""".stripMargin
  }

  override def buildPower: String = { "323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm" }

  override def buildEngine: String = { "3.6L V 6 DOHC and variable valve timing" }

  override def buildBrakes: String = { "Four-wheel disc brakes: two ventilated. Electronic brake distribution. Stability control" }

  override def buildSeats: String = {
    """Seats: Driver sports front seat with one power adjustments manual height,
    | front passenger seat sports front seat with one power adjustments""".stripMargin
  }

  override def buildWindows: String = { "Front windows with one-touch on two windows" }

  override def buildFuelType: String = { "Petrol 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range" }

  override def getCar: String = { "Sports" }

}
