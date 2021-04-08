import Dependencies._

name := "calculator"
scalaVersion := "2.13.5"
version := "0.1.5"
organization := "safe2008"

// configs for sbt-github-packages plugin
  // val githubOwner = settingKey[String]("The github user or organization name")
  // val githubRepository = settingKey[String]("The github repository hosting this package")
  // val githubTokenSource = settingKey[TokenSource]("Where to get the API token used in publication (defaults to github.token in the git config)")
  // val githubSuppressPublicationWarning = settingKey[Boolean]("Whether or not to suppress the publication warning (default: false, meaning the warning will be printed)")
  // val githubPublishTo = taskKey[Option[Resolver]]("publishTo setting for deploying artifacts to GitHub packages")

githubOwner := "safe2008"
githubRepository := "sbt-github-package-demo"
githubTokenSource := TokenSource.Or(TokenSource.Environment("GITHUB_TOKEN"), TokenSource.GitConfig("github.token"))
// publishConfiguration := publishConfiguration.value.withOverwrite(true)
// publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true)

lazy val root = (project in file("."))
  .settings(
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
