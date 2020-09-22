import Dependencies._

scalaVersion := "2.13.3"
version := "0.1.0-SNAPSHOT"
organization := "supermanue"
name := "ExampleLibrary"

githubOwner := "gjuoun"
githubRepository := "example-library"

lazy val root = (project in file("."))
  .settings(
    name := "helloPackage",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
