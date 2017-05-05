package factory

object TestFactory extends App {
  val creator: Creator = new ConcreteCreator()
  val product: Product = creator.factory()
  System.out.println(product.solveProblem())
}