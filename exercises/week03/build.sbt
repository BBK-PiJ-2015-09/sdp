name := """exercises week03"""

version := "1.0"

scalaVersion := "2.12.1"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Need to pull this in for reflective capabilities.
libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
/*
// Exclude some folders associated with IntelliJ
ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"
*/
