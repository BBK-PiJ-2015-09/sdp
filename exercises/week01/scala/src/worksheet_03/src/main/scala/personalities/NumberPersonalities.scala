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
    var cache = 0
    do  {
      digits = n.toString.map(_.asDigit)
      cache = 0
      for(digit <- digits) cache += (digit * digit)
    } while ( cache != 1 && cache != 4)
    cache == 1
  }

}
