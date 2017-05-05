package film

class Director(_firstName: String, _lastName: String, _dateOfBirth: Int) {
  def firstName() = { _firstName }
  def lastName() = { _lastName }
  def dateOfBirth() = { _dateOfBirth }
  def name() = { firstName + " " + lastName }
}

object Director {
  def apply(firstName: String, lastName: String, dateOfBirth: Int): Director = {
    new Director(firstName, lastName, dateOfBirth)
  }

  def older(a : Director, b : Director) = {
    if (a.dateOfBirth < b.dateOfBirth) a else b
  }
}