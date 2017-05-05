package singleton

object TestSingleton extends App {
  System.out.println(SingletonA.lowercase())
  System.out.println(SingletonA.uppercase())
  System.out.println(SingletonB.lowercase())
  System.out.println(SingletonB.uppercase())
  System.out.println(ProtectedSingletonC.lowercase())
  System.out.println(ProtectedSingletonC.uppercase())
}
