package worksheet_01

import scala.io.StdIn.readLine

object NumberJudge {

  def main(args: Array[String]): Unit = {
    print("Please enter a number: ")
    var input = readLine().toInt
    if(input > 100) {
      println("That's a big number")
    } else {
      println("That's a small number")
    }

  }

}
