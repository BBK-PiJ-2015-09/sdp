package film

class Director(_firstName: String, _lastName: String, _dateOfBirth: Int) {
  def firstName() = { _firstName }
  def lastName() = { _lastName }
  def dateOfBirth() = { _dateOfBirth }
  def name() = { firstName + " " + lastName }
}
