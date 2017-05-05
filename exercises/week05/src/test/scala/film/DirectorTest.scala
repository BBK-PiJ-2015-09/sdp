package film

import org.scalatest.{BeforeAndAfter, FunSuite}

class DirectorTest extends FunSuite with BeforeAndAfter {

  var director: Director = _

  before {
    director = new Director("John", "Smith", 1990)
  }

  test("firstName") {
    assert(director.firstName === "John")
  }

  test("lastName") {
    assert(director.lastName === "Smith")
  }

  test("dateOfBirth") {
    assert(director.dateOfBirth === 1990)
  }

  test("name") {
    assert(director.name() === "John Smith")
  }

  test("companion object") {
    assert(Director("John", "Smith", 1990).name === "John Smith")
  }

  test("older") {
    assert(Director.older(director, Director("Jane", "Smith", 1992)).name === "John Smith")
  }

}
