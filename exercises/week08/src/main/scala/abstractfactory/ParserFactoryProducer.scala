package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String): AbstractParserFactory = s match {
    case "NYCFactory" => new NYCParserFactory()
    case _ => new LondonParserFactory()
  }

}
