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

}