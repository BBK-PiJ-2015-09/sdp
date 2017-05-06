package composite

object TestCompositePattern extends App {
    // 11. a) The Composite pattern allows developers to 'compose' objects together to make a greater object which
    //          has the same interface as any of its components.
    //     b) You could use the composite pattern to DRY out a set of classes which are very similar.
    //     c) The 4 participants of the composite design pattern are the Leaf, the Component, the Composite and the Client.

    val parentTag: HtmlTag = HtmlParentElement("<html>")
    parentTag.setStartTag("<html>")
    parentTag.setEndTag("</html>")

    val p1: HtmlTag = HtmlParentElement("<body>")
    p1.setStartTag("<body>")
    p1.setEndTag("</body>")
    parentTag.addChildTag(p1)

    var child1: HtmlTag = HtmlElement("<P>")
    child1.setStartTag("<P>")
    child1.setEndTag("</P>")
    child1.setTagBody("Testing html tag library")
    p1.addChildTag(child1)

    child1 = HtmlElement("<P>")
    child1.setStartTag("<P>")
    child1.setEndTag("</P>")
    child1.setTagBody("Paragraph 2")

    p1.addChildTag(child1)
    parentTag.generateHtml
}
