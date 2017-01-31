package personalities

object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]): Unit = {

  }

  def isPrime(n: Int): Boolean = {
    if (n == 1) false else (for(i <- 2 until n) yield n % i != 0).forall(_ == true)
  }

  def isHappy(n: Int): Boolean = {
    var digits = scala.collection.immutable.IndexedSeq[Int]()
    var cache = n
    do  {
      digits = cache.toString.map(_.asDigit)
      cache = 0
      for(digit <- digits) {
        cache += (digit * digit)
      }
    } while (cache != 1 && cache != 4)
    cache == 1
  }

  def isTriangular(n: Int): Boolean = {
    var total = n
    var index = 0
    while (total > 0) {
      index += 1
      total -= index
    }
    total == 0
  }

  def isSquare(n: Int): Boolean = {
    if (n == 0) {
      return false
    }
    var total = n
    var index = 1
    while (total > 0) {
      total -= index
      index += 2
    }
    total == 0
  }

  def isSmug(n: Int): Boolean = {
    var total = n
    var index = 0
    var square = 0
    var result = false
    while (square < n) {
      index += 1
      square = index * index
      total = n - square
      if (isSquare(total)) {
        result = true
      }
    }
    result
  }

  def isHonest(n: Int): Boolean = {
    var k = 1
    var result = true
    while (k < n && result) {
      if (n / k == k && k * k != n) {
        result = false
      }
      k += 1
    }
    result
  }

  def isPronic(n: Int): Boolean = {
    var k = 1
    var product = 0
    var result = false
    while (product < n && !result) {
      product = k * (k + 1)
      if (product == n) {
        result = true
      }
      k += 1
    }
    result
  }

  def dividesEvenly(dividend: Int, divisor: Int): Boolean = {
    dividend % divisor == 0
  }

  def sumOfPositiveDivisorsOf(n: Int): Int = {
    var k = 1
    var sum = 0
    while(k < n) {
      if (dividesEvenly(n, k))
        sum += k
      k += 1
    }
    sum
  }
}
