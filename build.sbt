name := "SExp-L-Calc-Compiler"

scalaVersion := "2.10.2"

sourceDirectories in Compile += file("src")

mainClass in Compile := Some("Main")

scalacOptions ++= Seq(
  "-deprecation",
  "-feature"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test"
)

//packagerSettings

//packageArchetype.java_application

//packageSummary in Linux := "SExp->λ-Calculus Compiler"

//packageSummary in Windows := "SExp->λ-Calculus Compiler"

//packageDescription := "SExp->λ-Calculus Compiler"

//maintainer in Windows := "Leif Andersen"

//maintainer in Debian := "Leif Andersen <leif@leifandersen.net>"
