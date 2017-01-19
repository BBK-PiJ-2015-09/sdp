package worksheet_01

import scala.io.StdIn.readLine

object Readline {

  def main(args: Array[String]): Unit = {
    print("Please enter an even number: ")
    var input = readLine().toInt
    println("Thank you, half of your number is: " + input / 2)
  }

}
