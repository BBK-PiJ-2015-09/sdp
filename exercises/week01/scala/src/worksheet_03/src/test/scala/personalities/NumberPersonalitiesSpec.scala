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

  test("#isSquare") {
    assert(isSquare(1) == true)
    assert(isSquare(2) == false)
    assert(isSquare(3) == false)
    assert(isSquare(4) == true)
    assert(isSquare(9) == true)
    assert(isSquare(16) == true)
    assert(isSquare(17) == false)
    assert(isSquare(999999) == false)
    assert(isSquare(1000000) == true)
  }

  test("#isSmug") {
    assert(isSmug(1) == false)
    assert(isSmug(2) == true)
    assert(isSmug(3) == false)
    assert(isSmug(4) == false)
    assert(isSmug(5) == true)
    assert(isSmug(6) == false)
    assert(isSmug(7) == false)
    assert(isSmug(8) == true)
    assert(isSmug(9) == false)
    assert(isSmug(10) == true)
    assert(isSmug(11) == false)
    assert(isSmug(12) == false)
    assert(isSmug(13) == true)
  }

  test("#isHonest") {
    assert(isHonest(1) == true)
    assert(isHonest(2) == true)
    assert(isHonest(3) == true)
    assert(isHonest(4) == true)
    assert(isHonest(5) == false)
    assert(isHonest(6) == true)
    assert(isHonest(7) == true)
    assert(isHonest(8) == true)
    assert(isHonest(9) == true)
    assert(isHonest(10) == false)
    assert(isHonest(11) == false)
    assert(isHonest(12) == true)
    assert(isHonest(13) == true)
    assert(isHonest(14) == true)
    assert(isHonest(15) == true)
  }

  test("#isPronic") {
    assert(isPronic(1) == false)
    assert(isPronic(2) == true)
    assert(isPronic(3) == false)
    assert(isPronic(4) == false)
    assert(isPronic(5) == false)
    assert(isPronic(6) == true)
    assert(isPronic(7) == false)
    assert(isPronic(12) == true)
    assert(isPronic(19) == false)
    assert(isPronic(20) == true)
  }

  test("#isDeficient") {
    assert(isDeficient(5) == true)
    assert(isDeficient(6) == false)
    assert(isDeficient(24) == false)
  }

  test("#isPerfect") {
    assert(isPerfect(5) == false)
    assert(isPerfect(6) == true)
    assert(isPerfect(24) == false)
  }

  test("#isAbundant") {
    assert(isAbundant(5) == false)
    assert(isAbundant(6) == false)
    assert(isAbundant(24) == true)
  }

  test("#dividesEvenly") {
    assert(dividesEvenly(1, 2) == false)
    assert(dividesEvenly(2, 2) == true)
    assert(dividesEvenly(3, 2) == false)
    assert(dividesEvenly(4, 2) == true)
  }

  test("#sumOfPositiveDivisorsOf") {
    assert(sumOfPositiveDivisorsOf(1) == 0)
    assert(sumOfPositiveDivisorsOf(2) == 1)
    assert(sumOfPositiveDivisorsOf(3) == 1)
    assert(sumOfPositiveDivisorsOf(4) == 3)
    assert(sumOfPositiveDivisorsOf(5) == 1)
    assert(sumOfPositiveDivisorsOf(24) == 36)
  }
}