package factory

object TestFactory extends App {
  val creator: Creator = new ConcreteCreator()
  val concreteProduct: Product = creator.factory(classOf[ConcreteProduct])
  System.out.println(concreteProduct.solveProblem())
}