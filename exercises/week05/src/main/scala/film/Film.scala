package film

case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge() = { yearOfRelease - director.dateOfBirth }
  def isDirectedBy(query : Director) = { query == director }
  def copy(_name: String = name, _yearOfRelease: Int = yearOfRelease, _imdbRating: Double = imdbRating, _director: Director = director) : Film = {
    new Film(_name, _yearOfRelease, _imdbRating, _director)
  }
}


object Film {
  def highestRating(a : Film, b : Film) = {
    if (a.imdbRating > b.imdbRating) a else b
  }

  def oldestDirectorAtTheTime(a : Film, b : Film) = {
    if (a.directorsAge > b.directorsAge) a else b
  }
}
