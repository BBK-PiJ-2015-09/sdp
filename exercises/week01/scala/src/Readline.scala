import scala.io.StdIn.{readLine,readInt}

object Readline {

  def main(args: Array[String]): Unit = {
    print("Please enter an even number: ")
    var input = readLine().toInt
    println("Thank you, half of your number is: " + 34input / 2)
  }

}
