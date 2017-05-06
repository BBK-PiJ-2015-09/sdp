package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String): AbstractParserFactory = {
    if (s == "NYCFactory") {
      new NYCParserFactory()
    } else {
      new LondonParserFactory()
    }
  }

}
