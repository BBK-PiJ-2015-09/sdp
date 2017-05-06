package abstractfactory

class NYCParserFactory extends AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser = {
    if (parserType == "NYCORDER") {
      println("NYC Parsing order XML...")
      new NYCXMLParser()
    } else {
      new GenericXMLParser()
    }
  }
}