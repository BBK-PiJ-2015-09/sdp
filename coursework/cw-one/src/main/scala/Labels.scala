/**
  * Created by birkbeck on 23/02/2017.
  */
case class Labels() {
  var labels: Seq[String] = Seq()

  override def toString(): String =
    labels.mkString(" : ")

  def add(l: String) = labels = labels :+ l

  def apply(k: Int) = labels(k)
}
