package abstractfactory

class NYCParserFactory extends AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser = parserType match {
    case "NYCORDER" => println("NYC Parsing order XML..."); new NYCXMLParser()
    case _ => new GenericXMLParser()
  }
}