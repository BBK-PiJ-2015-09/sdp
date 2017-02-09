package cats

sealed trait Feline {
  def dinner = this match {
    case Lion() => Antelope()
    case Tiger() => TigerFood()
    case Panther() => Licorice()
    case Cat() => Mice()
  }
}

final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat() extends Feline