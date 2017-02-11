// sealed trait MyTrait
// final case class Thing() extends MyTrait

case class Person(name: String, age: Int)


// Compile:
// scalac *.scala

// Decompile:
// java -jar cfr_0_119.jar Person.class

// classes
// case classes
// companion
// algebraic data types
// structural data types
