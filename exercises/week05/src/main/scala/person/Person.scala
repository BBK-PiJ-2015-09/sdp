package person

case class Person(firstName: String, lastName: String) {
  
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