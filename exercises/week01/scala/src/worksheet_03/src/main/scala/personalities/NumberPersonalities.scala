package personalities

object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]): Unit = {

  }

  def isPrime(n: Int): Boolean = {
    if(n == 1) {
      return false
    } else {
      val truthiness = for(i <- 2 until n)
        yield n % i == 0
      return truthiness.forall(_ == false)
    }
  }

}
