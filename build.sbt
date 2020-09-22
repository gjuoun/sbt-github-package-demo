import Dependencies._

name := "hellopackage"
scalaVersion := "2.13.3"
version := "0.1.5"
organization := "gjuoun"

// configs for sbt-github-packages plugin
githubOwner := "gjuoun"
githubRepository := "github-packages-playground"
githubTokenSource := TokenSource.GitConfig("github.token")

lazy val root = (project in file("."))
  .settings(
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
