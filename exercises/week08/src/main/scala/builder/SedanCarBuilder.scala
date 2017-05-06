package builder

//TODO

object SedanCarBuilder extends CarBuilder {
  override def buildBodyStyle: Unit = {
    """
      |Body: External dimensions: overall length (inches): 202.9,
      |overall width (inches): 76.2, overall height (inches): 60.7,
      |wheelbase (inches): 112.9, front track (inches): 65.3,
      |rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5
    """.stripMargin
  }

  override def buildPower: Unit = { "Power: 285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm" }

  override def buildEngine: Unit = {  "Engine: 3.5L Duramax V 6 DOHC" }

  override def buildBreaks: Unit = { "Brakes: Four-wheel disc brakes: two ventilated. Electronic brake distribution" }

  override def buildSeats: Unit = { "Seats: Front seat centre armrest.Rear seat centre armrest.Split-folding rear seats" }

  override def buildWindows: Unit = { "Windows: Laminated side windows. Fixed rear window with defroster" }

  override def buildFuelType: Unit = { "Fuel Type: Diesel 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range" }

  override def getCar: Car = ???
}
