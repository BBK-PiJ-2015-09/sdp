package com.acme.pizza

import org.scalatest.{FunSpec, GivenWhenThen}

class PizzaSpec extends FunSpec with GivenWhenThen {

  var pizza: Pizza = _

  describe("A Pizza") {

    it("Should start with no toppings") {
      Given("a new pizza")
      pizza = new Pizza
      Then("the topping count should be zero")
      assert(pizza.getToppings.size == 0)
    }

    it("Should allow removal of toppings") {
      Given("a new pizza with one topping")
      pizza = new Pizza
      pizza.addTopping(Topping("green olives"))

      When("the topping is removed")
      pizza.removeTopping(Topping("green olives"))

      Then("the topping count should be zero")
      assert(0 === pizza.getToppings.size)

    }

    it ("should allow the addition of toppings") {
      Given("a new pizza")
      pizza = new Pizza

      When("a topping is added")
      pizza.addTopping(Topping("green olives"))

      Then("the topping count should be incremented")
      assert(1 === pizza.getToppings.size)

      And("the topping should be what was added")
      val t = pizza.getToppings(0)
      assert(t === new Topping("green olives"))
    }
  }

}