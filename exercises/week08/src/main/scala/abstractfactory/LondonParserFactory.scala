package abstractfactory

class LondonParserFactory extends AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser = {
    if (parserType == "LondonFEEDBACK") {
      println("London Parsing feedback XML...")
      new LondonXMLParser()
    } else {
      new GenericXMLParser()
    }
  }
}