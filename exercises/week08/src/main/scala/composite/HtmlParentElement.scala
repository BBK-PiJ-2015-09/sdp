package composite

case class HtmlParentElement(s: String) extends HtmlTag(s) {
  override def setStartTag(tag: String): Unit = { startTag = tag }

  override def setEndTag(tag: String): Unit = { endTag = tag }

  override def generateHtml: Unit = {
    println(startTag)
    for(child <- getChildren) { child.generateHtml }
    println(endTag)
  }
}
