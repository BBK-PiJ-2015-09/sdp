package strategy

case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): String = {
    "[LowerTextFormatter]: " + text.toLowerCase
  }
}
