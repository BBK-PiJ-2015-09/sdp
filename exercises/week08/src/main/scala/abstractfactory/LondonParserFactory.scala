package abstractfactory

class LondonParserFactory extends AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser = parserType match {
    case "LondonFEEDBACK" => println("London Parsing feedback XML..."); new LondonXMLParser()
    case _ => new GenericXMLParser()
  }
}