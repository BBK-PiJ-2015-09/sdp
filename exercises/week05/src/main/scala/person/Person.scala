package person

class Person(_firstName: String, _lastName: String) {

  def firstName() : String = {
    _firstName
  }

  def lastName() : String = {
    _lastName
  }

  def fullName() : String = {
    firstName + " " + lastName
  }

}

object Person {
  def apply(firstName: String, lastName: String): Unit = {
    new Person(firstName, lastName)
  }

  def apply(fullName: String) = {
    val names = fullName.split(" ")
    new Person(names(0), names(1))
  }
}