import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]){

    val favNums = new Array[Int](20)

    val friends = Array("Alex", "Otto")

    friends(0) = "Rosanna"

    println("Best friends " + friends(0))

    val friends2 = ArrayBuffer[String]()

    friends2.insert(0, "Phil")

    friends2 += "Mark"

    friends2 ++= Array("Susy", "Paul")

  }
}
