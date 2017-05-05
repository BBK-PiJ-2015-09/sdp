package film

import org.scalatest.{BeforeAndAfter, FunSuite}

class FilmTest extends FunSuite with BeforeAndAfter {

  var film: Film = _
  var director: Director = _

  before {
    director = new Director("Cameron", "Crowe", 1957)
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
    assert(!film.isDirectedBy(new Director("Steven", "Spielberg", 1946)))
  }

}
