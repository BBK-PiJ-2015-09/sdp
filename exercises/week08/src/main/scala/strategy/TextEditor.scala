package strategy

case class TextEditor(formatter: TextFormatter) {
  def publishText(s: String) {
    println(formatter.format(s))
  }

}
