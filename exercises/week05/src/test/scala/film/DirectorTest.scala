package film

import org.scalatest.{BeforeAndAfter, FunSuite}

class DirectorTest extends FunSuite with BeforeAndAfter {

  var director: Director = _

  before {
    director = new Director("John", "Smith", 1990)
  }

  test("firstName") {
    assert(director.firstName() === "John")
  }

  test("lastName") {
    assert(director.lastName() === "Smith")
  }

  test("name") {
    assert(director.name() === "John Smith")
  }

}
