package composite

import scala.collection.mutable.ListBuffer

abstract class HtmlTag(tagName: String) {
  var tagBody: String = _
  private var childTags: ListBuffer[HtmlTag] = ListBuffer[HtmlTag]()
  var startTag: String = _
  var endTag: String = _

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = { this.tagBody = tagBody }

  def addChildTag(htmlTag: HtmlTag) = { childTags += htmlTag }

  def removeChildTag(htmlTag: HtmlTag) = { childTags -= htmlTag }

  def getChildren: List[HtmlTag] = { childTags.toList }

  def generateHtml
}