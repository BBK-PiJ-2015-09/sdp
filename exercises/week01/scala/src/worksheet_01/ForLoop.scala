package worksheet_01

object ForLoop {

  def main(args: Array[String]): Unit = {

    var i = 0

    for(i <- 1 to 25) {
      println(i + " " + (i * i) + " " + (i * i * i))
    }

  }

}
