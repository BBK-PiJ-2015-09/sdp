package strategy

case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): String = {
    "[CapTextFormatter]: " + text.toUpperCase
  }
}
