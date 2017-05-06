package abstractfactory

object TestAbstractFactoryPattern {
  // 3. It is appropriate to use the abstract factory pattern when there is a common interface but many ways to implement it,
  // and the implementation can be done in different ways as long as the interface is adhered to. It allows the use of
  // composition with different concrete factories via the common interface.

  def main(args: Array[String]) {
    var parserFactory: AbstractParserFactory = ParserFactoryProducer.getFactory("NYCFactory")
    var parser: XMLParser = parserFactory.getParserInstance("NYCORDER")
    var msg: String = ""
    msg = parser.parse
    println(msg)
    println("************************************")
    parserFactory = ParserFactoryProducer.getFactory("LondonFactory")
    parser = parserFactory.getParserInstance("LondonFEEDBACK")
    msg = parser.parse
    println(msg)
  }
}