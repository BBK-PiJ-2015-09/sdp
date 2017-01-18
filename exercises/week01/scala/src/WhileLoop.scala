import scala.io.StdIn.readLine

object WhileLoop {

  def main(args: Array[String]): Unit = {
    var input = 0

    do {
      print("Please enter a number: ")
      input = readLine().toInt
      println("You entered: " + input)
      println("The square of " + input + " is " + input * input)
    } while (input != 0)

    println("Thank you, goodbye :)")

  }

}
