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
