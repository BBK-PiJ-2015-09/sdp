package personalities

import personalities.NumberPersonalities._
import org.scalatest.FunSuite

class NumberPersonalitiesSpec extends FunSuite {

  test("#isPrime") {
    assert(isPrime(1) == false)
    assert(isPrime(2) == true)
    assert(isPrime(3) == true)
    assert(isPrime(4) == false)
    assert(isPrime(5) == true)
    assert(isPrime(6) == false)
    assert(isPrime(7) == true)
    assert(isPrime(8) == false)
    assert(isPrime(9) == false)
    assert(isPrime(10) == false)
    assert(isPrime(997) == true)
    assert(isPrime(998) == false)

  }

  test("#isHappy") {
    assert(isHappy(1) == true)
    assert(isHappy(2) == false)
    assert(isHappy(19) == true)
    assert(isHappy(999) == false)
    assert(isHappy(1000) == true)
  }

  test("#isTriangular") {
    assert(isTriangular(1) == true)
    assert(isTriangular(2) == false)
    assert(isTriangular(3) == true)
    assert(isTriangular(6) == true)
    assert(isTriangular(10) == true)
    assert(isTriangular(15) == true)
    assert(isTriangular(16) == false)
  }

}