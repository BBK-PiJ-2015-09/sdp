import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]){

    def factorial(num : BigInt) : BigInt = {
      if(num <= 1)
        1
      else
        num * factorial(num -1)
    }

    println("Factorial of 4 = ") + factorial(4))

  }
}
