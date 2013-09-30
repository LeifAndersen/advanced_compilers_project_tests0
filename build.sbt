name := "SExp->λ-Calculus Compiler"

scalaVersion := "2.10.2"

sourceDirectories in Compile += file("src")

mainClass in Compile := Some("Main")

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test"
)
