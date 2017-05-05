package film

import org.scalatest.{BeforeAndAfter, FunSuite}

class FilmTest extends FunSuite with BeforeAndAfter {

  var film: Film = _
  var director: Director = _
  var spielberg: Director = _

  before {
    director = new Director("Cameron", "Crowe", 1957)
    spielberg = new Director("Steven", "Spielberg", 1946)
    film = new Film("Almost Famous", 2000, 9.9, director)
  }

  test("name") {
    assert(film.name() === "Almost Famous")
  }

  test("yearOfRelease") {
    assert(film.yearOfRelease() === 2000)
  }

  test("imdbRating") {
    assert(film.imdbRating() === 9.9)
  }

  test("director") {
    assert(film.director() === director)
  }

  test("directorsAge") {
    assert(film.directorsAge() === 43)
  }

  test("isDirectedBy") {
    assert(film.isDirectedBy(director))
  }

  test("isNotDirectedBy") {
    assert(!film.isDirectedBy(spielberg))
  }

  test("copy") {
    val copy = film.copy("Best Film Ever")
    assert(copy.name() === "Best Film Ever")
    assert(copy.yearOfRelease() === 2000)
    assert(copy.imdbRating() === 9.9)
    assert(copy.isDirectedBy(director))
  }

  test("copycopycopy") {
    val copy = film.copy().copy().copy()
    assert(copy.name() === "Almost Famous")
    assert(copy.yearOfRelease() === 2000)
    assert(copy.imdbRating() === 9.9)
    assert(copy.isDirectedBy(director))
  }

  test("companion object") {
    assert(Film("Almost Famous", 2000, 9.9, director).name === "Almost Famous")
  }

  test("highestRating") {
    assert(Film.highestRating(film, Film("Jerry Maguire", 1996, 7.3, director)) === film)
  }

  test("oldestDirectorAtTheTime") {
    assert(Film.oldestDirectorAtTheTime(Film("Jaws", 1975, 8.0, spielberg), film) === film)
  }

}
