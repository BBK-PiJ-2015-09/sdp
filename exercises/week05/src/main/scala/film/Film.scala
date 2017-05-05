package film

class Film(_name: String, _yearOfRelease: Int, _imdbRating: Double, _director: Director) {
  def name() = { _name }
  def yearOfRelease() = { _yearOfRelease }
  def imdbRating() = { _imdbRating }
  def director() = { _director }
  def directorsAge() = { yearOfRelease() - director.dateOfBirth() }
  def isDirectedBy(query : Director) = { query == director }
  def copy(_name: String = name(), _yearOfRelease: Int = yearOfRelease(), _imdbRating: Double = imdbRating(), _director: Director = director()): Film = {
    new Film(_name, _yearOfRelease, _imdbRating, _director)
  }
}


object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  def highestRating(a : Film, b : Film) = {
    if (a.imdbRating > b.imdbRating) a else b
  }

  def oldestDirectorAtTheTime(a : Film, b : Film) = {
    if (a.directorsAge > b.directorsAge) a else b
  }
}
