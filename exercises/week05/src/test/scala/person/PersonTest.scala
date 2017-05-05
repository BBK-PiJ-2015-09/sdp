package person

import org.scalatest.{BeforeAndAfter, FunSuite}

class PersonTest extends FunSuite with BeforeAndAfter {

  var person: Person = _

  before {
    person = new Person("John", "Smith")
  }

  test("firstName") {
    assert(person.firstName() === "John")
  }

  test("lastName") {
    assert(person.lastName() === "Smith")
  }

  test("fullName") {
    assert(person.fullName() === "John Smith")
  }

}
