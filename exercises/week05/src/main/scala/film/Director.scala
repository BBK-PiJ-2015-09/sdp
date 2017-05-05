package film

case class Director(firstName: String, lastName: String, dateOfBirth: Int) {
  def name() = { firstName + " " + lastName }
}

object Director {
  def older(a : Director, b : Director) = {
    if (a.dateOfBirth < b.dateOfBirth) a else b
  }
}