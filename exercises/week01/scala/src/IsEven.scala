import scala.io.StdIn.readLine

object IsEven {

  def main(args: Array[String]): Unit = {
    var input = 0;

    do {
      print("Please enter a number: ")
      input = readLine().toInt
      println("Thank you, is your number even? Answer: " + isEven(input))
    } while(input != 0)
  }

  def isEven(i: Int): Boolean = {
    if (i % 2 == 0) {
      return true
    } else {
      return false
    }
  }

}
