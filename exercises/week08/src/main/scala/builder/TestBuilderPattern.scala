package builder

object TestBuilderPattern {
  // 5. As applications get more complex, objects and by extension their constructors may get larger - this is construction bloat.
  // At a certain point it makes sense to break this logic out into a builder. Builders can be shared between objects with similar
  // interfaces to permit more modular development.

  def main(args: Array[String]) {
    var carBuilder: CarBuilder = SedanCarBuilder
    var director: CarDirector = CarDirector(carBuilder)

    director.build
    println(carBuilder.getCar)

    carBuilder = SportsCarBuilder
    director = CarDirector(carBuilder)

    director.build
    println(carBuilder.getCar)
  }
}
