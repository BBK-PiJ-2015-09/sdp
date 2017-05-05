package factory

object TestFactory extends App {
  val creator: Creator = new ConcreteCreator()
  val concreteProduct: Product = creator.factory("normal situation")
  val differentProduct: Product = creator.factory("Let's have something different!")
  System.out.println(concreteProduct.solveProblem())
  System.out.println(differentProduct.solveProblem())

}