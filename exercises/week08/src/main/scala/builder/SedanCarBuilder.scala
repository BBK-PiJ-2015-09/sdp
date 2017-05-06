package builder

object SedanCarBuilder extends CarBuilder {
  override def buildBodyStyle: String = {
    """External dimensions: overall length (inches): 202.9,
    | overall width (inches): 76.2, overall height (inches): 60.7,
    | wheelbase (inches): 112.9, front track (inches): 65.3,
    | rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5""".stripMargin
  }

  override def buildPower: String = { "285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm" }

  override def buildEngine: String = {  "3.5L Duramax V 6 DOHC" }

  override def buildBrakes: String = { "Four-wheel disc brakes: two ventilated. Electronic brake distribution" }

  override def buildSeats: String = { "Front seat centre armrest.Rear seat centre armrest.Split-folding rear seats" }

  override def buildWindows: String = { "Laminated side windows. Fixed rear window with defroster" }

  override def buildFuelType: String = { "Diesel 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range" }

  override def getCar: String = { "Sedan" }

}
