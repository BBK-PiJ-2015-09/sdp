package film

class Film(_name: String, _yearOfRelease: Int, _imdbRating: Double, _director: Director) {
  def name() = { _name }
  def yearOfRelease() = { _yearOfRelease }
  def imdbRating() = { _imdbRating }
  def director() = { _director }
  def directorsAge() = { yearOfRelease() - director.dateOfBirth() }
  def isDirectedBy(query : Director) = { query == director }
}
