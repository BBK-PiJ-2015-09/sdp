import cats._

// Feline isa Lion, Tiger, Panther, or Cat
sealed trait Feline {
  def dinner: Food
}

final case class Lion() extends Feline {
  def dinner = Antelope()
}
final case class Tiger() extends Feline {
  def dinner = TigerFood()
}
final case class Panther() extends Feline {
  def dinner = Licorice()
}
final case class Cat() extends Feline {
  def dinner = Mice()
}

// println(Lion.dinner)
// println(Tiger)
// println(Panther)
// println(Cat)
