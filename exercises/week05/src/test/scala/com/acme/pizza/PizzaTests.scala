package com.acme.pizza

import org.scalatest.{BeforeAndAfter, FunSuite}

class PizzaTests extends FunSuite with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  test("new pizza has zero toppings") {
    assert(pizza.getToppings.size == 0)
  }

  test("adding one topping") {
    pizza.addTopping(Topping("green olives"))
    assert(pizza.getToppings.size === 1)
  }

  // mark that you want a test here in the future
  test ("test pizza pricing") (pending)

  test("new pizza has zero toppings (version 2)") {
    // intentional error here; size should be 0
    assert(pizza.getToppings.size === 1)
  }

  test("new pizza has zero toppings (version 3)") {
    // `expectResult` is now `assertResult`
    // expectResult(1) {
    assertResult(1) {
      pizza.getToppings.size
    }
  }

  test ("should allow removal of toppings") (pending)

  test ("catching an exception 1") {
    val thrown = intercept[Exception] {
      pizza.boom
    }
    assert(thrown.getMessage === "Boom!")
  }

  test ("catching an exception 2") {
    intercept[Exception] { pizza.boom }
  }

}